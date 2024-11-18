USE QLNT;

-- Insert sample data into tables

-- DonViTinh table

INSERT INTO [dbo].[Voucher] (maVoucher, tenVoucher, moTa, ngayApDung, ngayKetThuc)
VALUES
('VOUCHER_001_10_PERCENT', N'Voucher 10%', N'Giảm giá 10% cho đơn hàng từ 100,000 VND', '2024-10-01', '2024-12-31'),
('VOUCHER_002_20_PERCENT', N'Voucher 20%', N'Giảm giá 20% cho đơn hàng từ 200,000 VND', '2024-10-05', '2024-12-31'),
('VOUCHER_003_30_PERCENT', N'Voucher 30%', N'Giảm giá 30% cho đơn hàng từ 300,000 VND', '2024-10-10', '2024-12-31'),
('VOUCHER_004_40_PERCENT', N'Voucher 40%', N'Giảm giá 40% cho đơn hàng từ 400,000 VND', '2024-10-15', '2024-12-31'),
('VOUCHER_005_50_PERCENT', N'Voucher 50%', N'Giảm giá 50% cho đơn hàng từ 500,000 VND', '2024-10-20', '2024-12-31'),
('VOUCHER_006_BIRTHDAY', N'Voucher Sinh Nhật', N'Giảm giá 15% cho khách hàng vào ngày sinh nhật', '2024-11-01', '2024-11-30'),
('VOUCHER_007_NEW_YEAR', N'Voucher Mừng Năm Mới', N'Giảm giá 25% cho đơn hàng bất kỳ', '2025-01-01', '2025-01-31'),
('VOUCHER_008_BLACK_FRIDAY', N'Voucher Black Friday', N'Giảm giá 50% trong ngày Black Friday', '2024-11-24', '2024-11-24'),
('VOUCHER_009_REWARD_POINTS', N'Voucher Tích Điểm', N'Giảm giá 10% cho khách hàng có trên 200 điểm tích lũy', '2024-10-01', '2025-01-01'),
('VOUCHER_010_NEW_CUSTOMER', N'Voucher Khách Hàng Mới', N'Giảm giá 5% cho khách hàng lần đầu mua sắm', '2024-10-01', '2024-12-31');

INSERT INTO DonViTinh (maDonViTinh, ten) VALUES
('DVT001', N'Vỉ'),
('DVT002', N'Viên'),
('DVT003', N'Chai'),
('DVT004', N'Hộp');

-- LoaiThuoc table
INSERT INTO LoaiThuoc (maLoai, tenLoai) VALUES
('TN001', N'Thuốc Nội'),
('TP002', N'Thuốc Pha'),
('TH003', N'Thuốc Hỗn Hợp'),
('TT004', N'Thuốc Trị');

-- XuatXu table
INSERT INTO XuatXu (maXuatXu, ten) VALUES
('VN24001', N'Việt Nam'),
('CN24002', N'Trung Quốc'),
('US24003', N'Mỹ'),
('JP24004', N'Nhật Bản');

-- NhaCungCap table
INSERT INTO NhaCungCap (maNCC, tenNCC, diaChi, email, sdt, trangThai) VALUES
('NCC001', N'Công ty dược phẩm A', N'Hà Nội', 'a@gmail.com', '0987654321', 1),
('NCC002', N'Công ty dược phẩm B', N'Hồ Chí Minh', 'b@gmail.com', '0987654322', 1),
('NCC003', N'Công ty dược phẩm C', N'Đà Nẵng', 'c@gmail.com', '0987654323', 1),
('NCC004', N'Công ty dược phẩm D', N'Cần Thơ', 'd@gmail.com', '0987654324', 1);

-- LoaiGiamGia table
INSERT INTO LoaiGiamGia (maLoaiGiamGia, tenLoai) VALUES
('GGPT24090401', N'Giảm giá trên % hóa đơn'),
('GGTI24090402', N'Giảm giá 10.000 trên tổng hóa đơn'),
('GGTT24090403', N'Giảm giá theo giá trị sản phẩm'),
('GGTD24090404', N'Giảm giá theo số lượng sản phẩm');

-- GiamGia table
INSERT INTO GiamGia (maGiamGia, tenGiamGia, moTa, donViTinh, maLoaiGiamGia) VALUES
('MGGABC0001', N'Giảm giá 10%', N'Giảm 10% cho tất cả sản phẩm', N'%', 'GGPT24090401'),
('MGGDEF0002', N'Giảm giá 20.000đ', N'Giảm 20.000đ cho mỗi hóa đơn', N'đ', 'GGTI24090402'),
('MGGHIJ0003', N'Giảm giá 30% cho sản phẩm A', N'Giảm 30% cho sản phẩm A', N'%', 'GGTT24090403'),
('MGGKLM0004', N'Giảm giá 50% khi mua 3 sản phẩm B', N'Giảm 50% cho sản phẩm B khi mua 3 sản phẩm B', N'sản phẩm', 'GGTD24090404');

-- Thuoc table
INSERT INTO Thuoc (maThuoc, tenThuoc, gia, hsd, nsx, thue, soLuongTon, moTa, maLoai, maXuatXu, maDonViTinh, maNCC, maGiamGia) VALUES
('TCIO1', N'Paracetamol 500mg', 10000, '2025-12-31', '2024-01-01', 10, 100, N'Thuốc giảm đau', 'TN001', 'VN24001', 'DVT001', 'NCC001', 'MGGABC0001'),
('TCIO2', N'Aspirin 100mg', 8000, '2025-12-31', '2024-01-01', 10, 80, N'Thuốc giảm đau', 'TN001', 'CN24002', 'DVT002', 'NCC002', 'MGGDEF0002'),
('TCIO3', N'Ibuprofen 400mg', 12000, '2025-12-31', '2024-01-01', 10, 120, N'Thuốc giảm đau', 'TN001', 'US24003', 'DVT003', 'NCC003', 'MGGHIJ0003'),
('TCIO4', N'Panadol Extra', 15000, '2025-12-31', '2024-01-01', 10, 150, N'Thuốc giảm đau', 'TN001', 'JP24004', 'DVT004', 'NCC004', 'MGGKLM0004');

-- VaiTro table
INSERT INTO VaiTro (maVaiTro, tenVaiTro) VALUES
('NVQL1203', N'Nhân viên quản lý'),
('NVBH0824', N'Nhân viên bán hàng'),
('NVKT0923', N'Nhân viên kế toán'),
('NVKT0624', N'Nhân viên kho');

-- NhanVien table
INSERT INTO NhanVien (maNhanVien, tenNhanVien, email, diaChi, sdt, cccd, trangThai) VALUES
('NV250124001', N'Nguyễn Văn A', 'a@gmail.com', N'Hà Nội', '0987654321', '123456789', 1),
('NV250224002', N'Nguyễn Văn B', 'b@gmail.com', N'Hồ Chí Minh', '0987654322', '123456789', 1),
('NV250324003', N'Nguyễn Văn C', 'c@gmail.com', N'Đà Nẵng', '0987654323', '123456789', 1),
('NV250424004', N'Nguyễn Văn D', 'd@gmail.com', N'Cần Thơ', '0987654324', '123456789', 1);

-- TaiKhoan table
INSERT INTO TaiKhoan (tenTaiKhoan, password, trangThai, maVaiTro, maNhanVien) VALUES
('NVQL123', 'NVQL123@@', 1, 'NVQL1203', 'NV250124001'),
('NVBH456', 'NVBH456@@', 1, 'NVBH0824', 'NV250224002'),
('NVKT789', 'NVKT789@@', 1, 'NVKT0923', 'NV250324003'),
('NVKH012', 'NVKH012@@', 1, 'NVKT0624', 'NV250424004');

-- KhachHang table
INSERT INTO KhachHang (maKhachHang, tenKhachHang, sdt, diemTichLuy) VALUES
('KH00000001', N'Nguyễn Văn E', '0987654325', 100),
('KH00000002', N'Nguyễn Văn F', '0987654326', 80)


INSERT INTO HoaDon (maHD, ngayLap, tongTien, maNhanVien, maKH, maVoucher)
VALUES
('HD2501200425012400001', '2024-01-01', 200000, 'NV250124001', 'KH00000001', 'VOUCHER_001_10_PERCENT'),
('HD2502200425022400002', '2024-02-01', 300000, 'NV250224002', 'KH00000002', 'VOUCHER_010_NEW_CUSTOMER')


INSERT INTO ChiTietHoaDon (maHD, maThuoc, soLuong, donGia)
VALUES
('HD2501200425012400001', 'TCIO1', 2, 10000),
('HD2501200425012400001', 'TCIO2', 1, 8000)
