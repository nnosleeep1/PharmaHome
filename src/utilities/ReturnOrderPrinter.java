/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import entity.ChiTietDoiTra;
import entity.DoiTra;
import enums.ReturnOrderStatus;
import enums.TrangThaiDoiTra;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.imageio.ImageIO;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Sides;

/**
 *
 * @author Như Tâm
 */
public class ReturnOrderPrinter {
    private final DoiTra returnOrder;
    public static final String FONT = "resources/fonts/arial-unicode-ms.ttf";
    private static final String FILE_PATH = "lastReturnOrder.pdf";

    public static enum PrintStatus {
        NOT_FOUND_FILE,
        NOT_FOUND_PRINTER,
        COMPLETE
    }

    enum TextAlign {
        LEFT, CENTER, RIGHT;
    }

    public ReturnOrderPrinter(DoiTra returnOrder) {
        this.returnOrder = returnOrder;
    }

    private String getVND(double number) {
        return utilities.FormatNumber.toVND(number);
    }

    private void addTableHeader(PdfPTable table, Font font) {
        Stream.of("VAT", "Giá", "Số lượng", "Tổng tiền")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.WHITE);
                    header.setBorderWidth(1);
                    header.setPhrase(new Phrase(columnTitle, font));
                    header.setPadding(4);
                    table.addCell(header);
                });
    }

    public PrintStatus printFile() {
//        Tìm kiếm máy in và kích hoạt sự kiện in
        DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PAGEABLE;
        PrintRequestAttributeSet patts = new HashPrintRequestAttributeSet();
        patts.add(Sides.DUPLEX);
        PrintService[] ps = PrintServiceLookup.lookupPrintServices(flavor, patts);
        if (ps.length == 0) {
            throw new IllegalStateException("No Printer found");
        }

        PrintService myService = null;
        for (PrintService printService : ps) {
            if (printService.getName().equals("Your printer name")) {
                myService = printService;
                break;
            }
        }

        if (myService == null) {
            throw new IllegalStateException("Printer not found");
        }

        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
            Doc pdfDoc = new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
            DocPrintJob printJob = myService.createPrintJob();
            printJob.print(pdfDoc, new HashPrintRequestAttributeSet());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrderPrinter.class.getName()).log(Level.SEVERE, null, ex);
            return PrintStatus.NOT_FOUND_FILE;
        } catch (IOException ex) {
            Logger.getLogger(OrderPrinter.class.getName()).log(Level.SEVERE, null, ex);
            return PrintStatus.NOT_FOUND_FILE;

        } catch (PrintException ex) {
            Logger.getLogger(OrderPrinter.class.getName()).log(Level.SEVERE, null, ex);
            return PrintStatus.NOT_FOUND_PRINTER;
        }

        return PrintStatus.COMPLETE;
    }

    public static byte[] resizeImage(byte[] imageData, int targetWidth, int targetHeight) throws IOException {
        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(imageData));
        int originalWidth = originalImage.getWidth();
        int originalHeight = originalImage.getHeight();

        double widthRatio = (double) targetWidth / originalWidth;
        double heightRatio = (double) targetHeight / originalHeight;

        double ratio = Math.min(widthRatio, heightRatio);

        int scaledWidth = (int) Math.round(originalWidth * ratio);
        int scaledHeight = (int) Math.round(originalHeight * ratio);

        BufferedImage resizedImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.SCALE_SMOOTH);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();

        byte[] resizedImageData;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(resizedImage, "PNG", baos);
            resizedImageData = baos.toByteArray();
        }

        return resizedImageData;
    }

    public void generatePDF() {
        try {
            //Create Document instance.
            Document document = new Document();
            document.setMargins(16, 16, 32, 24);

            //Create OutputStream instance.
            OutputStream outputStream
                    = new FileOutputStream(new File(FILE_PATH));

            //Create PDFWriter instance.
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
            writer.setLanguage("VN");

            //Open the document.
            document.open();
            BaseFont bf = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//            Header
            Font headingFont = new Font(bf, 20, Font.BOLD);
            Font subHeadingFont = new Font(bf, 18, Font.BOLD);
            Font bold = new Font(bf, 16, Font.BOLD);
            Font italic = new Font(bf, 16, Font.ITALIC);
            Font font = new Font(bf, 16);
            LineSeparator separator = new LineSeparator(font);

            Paragraph sofware = new Paragraph("PHARMAHOME", headingFont);
            Paragraph desc = new Paragraph("\"Liều thuốc từ trái tim\"", italic);
            Paragraph store = new Paragraph("12 Nguyễn Văn Bảo, Phường 4, Gò Vấp, Hồ Chí Minh", bold);

            sofware.setAlignment(TextAlign.CENTER.ordinal());
            desc.setAlignment(TextAlign.CENTER.ordinal());
            store.setAlignment(TextAlign.CENTER.ordinal());
            document.add(sofware);
            document.add(desc);
            document.add(store);
            document.add(separator);

//            Content
            Paragraph orderTitle = new Paragraph("HÓA ĐƠN ĐỔI TRẢ", subHeadingFont);
            orderTitle.setAlignment(TextAlign.CENTER.ordinal());
            document.add(orderTitle);
            document.add(separator);

//            ReturnOrder info
            document.add(new Paragraph(String.format("Số hóa đơn đổi trả:  %s", returnOrder.getMaHDDT()), font));
            document.add(new Paragraph(String.format("Số hóa đơn:  %s", returnOrder.getHoaDon().getMaHD()), font));
            document.add(new Paragraph(String.format("Ngày tạo:  %s", returnOrder.getNgayDoiTra()), font));
            document.add(new Paragraph(String.format("Nhân viên:  %s", returnOrder.getNhanvien().getTenNhanVien()), font));
            document.add(new Paragraph(String.format("Khách hàng:  %s", returnOrder.getHoaDon().getKhachHang().getTenKhachHang()), font));
            document.add(separator);

//          ReturnOrder detail  
            PdfPTable table = new PdfPTable(4);
            table.setSpacingBefore(20);
            table.setWidthPercentage(100);
            addTableHeader(table, subHeadingFont);

            int index = 0;
            for (ChiTietDoiTra detail : returnOrder.getListDetail()) {
                PdfPCell cell = new PdfPCell(new Phrase(String.format("%d. %s", ++index, detail.getSanPham().getTenThuoc()), font));
                cell.setColspan(4);

                table.addCell(new PdfPCell(cell));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(detail.getSanPham().getThue()), font)));

                PdfPCell priceCell = new PdfPCell(new Phrase(getVND(detail.getGia()), font));
                table.addCell(priceCell);

                table.addCell(new PdfPCell(new Phrase(String.valueOf(detail.getSoLuong()), font)));
                table.addCell(new PdfPCell(new Phrase(getVND(detail.thanhTien()), font)));

            }

            document.add(table);

//            Order footer    
            document.add(new Paragraph("Tổng tiền: " + getVND(returnOrder.getHoaDon().getTongTien()), font));
            document.add(new Paragraph("Tiền hoàn: " + getVND(returnOrder.getTienTra()), subHeadingFont));
            //document.add(new Paragraph("Thanh toán: " + getVND(order.getTotalDue()), subHeadingFont));
            document.add(separator);

            boolean type = returnOrder.isLoai();
            if(type)
                document.add(new Paragraph("Loại đơn: Đơn trả", font));
            else
                document.add(new Paragraph("Loại đơn: Đơn đổi", font));
            document.add(new Paragraph("Lý do: " + returnOrder.getLiDO(), font));
            TrangThaiDoiTra status = returnOrder.getTrangThai();
            if(status.equals(ReturnOrderStatus.CANCEL)) 
                document.add(new Paragraph("Trạng thái: Từ chối", subHeadingFont));
            else if(status.equals(ReturnOrderStatus.SUCCESS))
                document.add(new Paragraph("Trạng thái: Đồng ý", subHeadingFont));
            else
                document.add(new Paragraph("Trạng thái: Đang chờ", subHeadingFont));
            

//            Footer
            document.add(separator);
            Paragraph hotline = new Paragraph("Tổng đài góp ý/khiếu nại: 1800 0000", bold);
            Paragraph note = new Paragraph("Lưu ý: PharmaHome chỉ xuất hóa đơn trong ngày, Quý khách vui lòng liên hệ thu ngân để được hỗ trợ nếu cần in lại hóa đơn.", italic);

            Paragraph note2 = new Paragraph("Cảm ơn quý khách. Hẹn gặp lại", font);

            hotline.setAlignment(TextAlign.CENTER.ordinal());
            note.setAlignment(TextAlign.CENTER.ordinal());
            note.setIndentationLeft(50);
            note.setIndentationRight(50);
            note2.setAlignment(TextAlign.CENTER.ordinal());

            document.add(hotline);
            document.add(note);
            document.add(note2);

//            Order barcode
            // Convert the BufferedImage to a byte array
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(BarcodeGenerator.generateBarcode(returnOrder.getMaHDDT()), "PNG", baos);
            byte[] bytes = resizeImage(baos.toByteArray(), 500, 200);
            // Create an Image from the byte array
            Image image = Image.getInstance(bytes);
            image.setAlignment(1);
            document.add(image);

            //Close document and outputStream.
            document.close();
            outputStream.close();

            Desktop d = Desktop.getDesktop();
            d.open(new File(FILE_PATH));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
