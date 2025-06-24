create database qltv;
use qltv;

IF OBJECT_ID('admin', 'U') IS NOT NULL
    DROP TABLE admin;

CREATE TABLE admin (
    username NVARCHAR(30) NOT NULL PRIMARY KEY,
    password NVARCHAR(45) NOT NULL
);

INSERT INTO admin (username, password)
VALUES (N'admin', N'12345');


IF OBJECT_ID('tb_dausach', 'U') IS NOT NULL
    DROP TABLE tb_dausach;

CREATE TABLE tb_dausach (
    MaDauSach NVARCHAR(15) NOT NULL PRIMARY KEY,
    TenSach NVARCHAR(45) NOT NULL,
    Soluong INT NOT NULL,
    TheLoai NVARCHAR(45) NOT NULL,
    TacGia NVARCHAR(45) NOT NULL,
    NXB NVARCHAR(45) NOT NULL,
    NamXB INT NOT NULL
);

INSERT INTO tb_dausach (MaDauSach, TenSach, Soluong, TheLoai, TacGia, NXB, NamXB)
VALUES 
(N'DS001', N'Toán 10', 99, N'SGK', N'Kim Đồng', N'Giáo dục', 2012),
(N'DS002', N'Văn 10', 90, N'SGK', N'Kim Đồng', N'Giáo dục', 2012),
(N'DS003', N'Lý 12', 15, N'SGK', N'Kim Đồng', N'Giáo dục', 2016),
(N'DS004', N'Hóa 12', 140, N'SGK', N'Kim Đồng', N'Giáo dục', 2015),
(N'DS005', N'Toán rời rạc', 130, N'Giáo trình', N'Cao Tuấn Dũng', N'BKHT', 2012),
(N'DS006', N'Lập trình Java', 31, N'Giáo trình', N'Lê Thị Hoa', N'BTH', 2009),
(N'DS007', N'Lập trình C++', 10, N'Giáo trình', N'Nguyễn Thành Công', N'BKHXH', 2015),
(N'DS008', N'Lập trình Python', 19, N'Giáo trình', N'Hoàng Nam', N'BTNN', 2002),
(N'DS009', N'Lập trình C#', 16, N'Giáo trình', N'Lê  Văn Nam', N'THT', 2010),
(N'DS010', N'Trí tuệ nhân tạo', 48, N'Giáo trình', N'Thành Nam', N'THH', 2015),
(N'DS011', N'Xác xuất thống kê', 47, N'Giáo trình', N'Phạm Hoàng', N'TSE', 2016),
(N'DS012', N'Giải tích 1', 119, N'Giáo trình', N'Vũ Mạnh', N'TFF', 2018),
(N'DS013', N'Doremon', 198, N'Truyện tranh', N'Kim Đồng', N'THF', 2012),
(N'DS014', N'Naruto', 300, N'Truyện tranh', N'Kim Đồng', N'TSD', 2018),
(N'DS015', N'Connan', 200, N'Truyện tranh', N'Kim Đồng', N'THT', 2020);


IF OBJECT_ID('tb_nguoimuon', 'U') IS NOT NULL
    DROP TABLE tb_nguoimuon;

CREATE TABLE tb_nguoimuon (
    MaNguoiMuon NVARCHAR(15) NOT NULL PRIMARY KEY,
    TenNguoiMuon NVARCHAR(45) NOT NULL,
    DiaChi NVARCHAR(45) NOT NULL ,
    Gmail NVARCHAR(45) NOT NULL UNIQUE,
    SDT NVARCHAR(45) NOT NULL UNIQUE
);

INSERT INTO tb_nguoimuon (MaNguoiMuon, TenNguoiMuon, DiaChi, Gmail, SDT)
VALUES 
(N'MN001', N'Trần Trọng Tuấn', N'Ninh Bình', N'trantuan@gmail.com', N'0349587256'),
(N'MN002', N'Nguyễn Đức Trình', N'Nam Định', N'ductr@gmail.com', N'0987845137'),
(N'MN003', N'Phạm Trung', N'Yến Bái', N'trungp@gmail.com', N'0987587451'),
(N'MN004', N'Hồ Sỹ Sơn', N'Nghệ An', N'sontt@gmail.com', N'0987541632'),
(N'MN005', N'Nguyễn Thắng', N'Nam Định', N'thanttt@gmail.com', N'0698745123'),
(N'MN007', N'Nguyễn Văn Nam', N'Bắc Ninh', N'nam27@gmail.com', N'0986564354'),
(N'MN008', N'Lê Minh Tùng', N'Hòa Bình', N'tung234@gmail.com', N'0978463123'),
(N'MN009', N'Phạm Văn Tân', N'Hà Nội', N'tanpahm@gmail.com', N'0893476587'),
(N'MN010', N'Nguyễn Long', N'Hải Dương', N'long@gmail.com', N'0234536546'),
(N'MN011', N'Nguyễn Đức Tâm', N'Hà Nội', N'tanttte@gmail.com', N'0987865432'),
(N'MN012', N'Phạm Văn Bình', N'Bắc Giang', N'vanbinh01@gmail.com', N'0989764532'),
(N'MN013', N'Lê Ngọc Bích', N'Hải Phòng', N'bicle@gmail.com', N'0765231456'),
(N'MN014', N'Trần Văn Hùng', N'Nghệ Tĩnh', N'hungtt@gmail.com', N'0954324541'),
(N'MN015', N'Nguyễn Duy An', N'Nam Định', N'angng@gmail.com', N'0987654321'),
(N'MN016', N'Vũ Văn Thưởng', N'Hà Nội', N'thungvuv@gmail.com', N'0234213546'),
(N'MN017', N'Phạm Bá Tuấn', N'Hải Phòng', N'phatuan@gmail.com', N'0945324154'),
(N'MN018', N'Phan Hải Long', N'Hà Nam', N'longpp@gmail.com', N'0394853132'),
(N'MN019', N'Vũ Văn Toản', N'Bình Định', N'vantoan@gmail.com', N'0746324123'),
(N'MN020', N'Phạm Nhật Long', N'Hà Đông', N'longnhat@gmail.com', N'0943251432'),
(N'MN021', N'Phan Hải Nam', N'Ninh Bình', N'namna@gmail.com', N'09847845124'),
(N'MN022', N'Lê Thành Trung', N'Hà Nội', N'trungtt@gmail.com', N'0287945124');

IF OBJECT_ID('tb_phieumuon', 'U') IS NOT NULL
    DROP TABLE tb_phieumuon;

CREATE TABLE tb_phieumuon (
    MaPhieuMuon NVARCHAR(15) NOT NULL PRIMARY KEY,
    NgayMuon DATE NOT NULL,
    HanTra DATE NOT NULL,
    MaSach NVARCHAR(15) NOT NULL,
    MaNguoiMuon NVARCHAR(15) NOT NULL,
    NgayTra DATE NULL,

    CONSTRAINT FK_PhieuMuon_NguoiMuon FOREIGN KEY (MaNguoiMuon)
        REFERENCES tb_nguoimuon (MaNguoiMuon),

    CONSTRAINT FK_PhieuMuon_Sach FOREIGN KEY (MaSach)
        REFERENCES tb_sach (MaSach)
);

INSERT INTO tb_phieumuon (MaPhieuMuon, NgayMuon, HanTra, MaSach, MaNguoiMuon, NgayTra)
VALUES
(N'P001', '2022-08-12', '2022-09-12', N'S001', N'MN001', '2022-09-10'),
(N'P002', '2022-01-12', '2022-02-12', N'S002', N'MN003', NULL),
(N'P003', '2022-06-08', '2022-10-10', N'S006', N'MN003', '2022-10-11'),
(N'P004', '2022-10-10', '2022-12-10', N'S005', N'MN007', NULL),
(N'P005', '2022-05-05', '2022-10-10', N'S010', N'MN004', NULL),
(N'P006', '2022-06-07', '2022-12-12', N'S004', N'MN009', NULL),
(N'P007', '2022-04-04', '2022-12-12', N'S023', N'MN003', NULL),
(N'P008', '2022-05-22', '2022-10-22', N'S009', N'MN005', NULL),
(N'P009', '2023-05-22', '2023-12-22', N'S011', N'MN008', NULL),
(N'P010', '2023-03-25', '2023-07-20', N'S013', N'MN004', '2023-05-25'),
(N'P011', '2023-01-01', '2023-05-01', N'S008', N'MN019', NULL),
(N'P012', '2022-06-07', '2023-01-01', N'S013', N'MN019', NULL),
(N'P013', '2022-06-07', '2023-12-22', N'S024', N'MN018', NULL),
(N'P014', '2023-12-22', '2023-11-01', N'S020', N'MN018', '2023-10-10'),
(N'P015', '2023-03-25', '2023-12-22', N'S020', N'MN001', NULL),
(N'P016', '2023-03-25', '2022-08-07', N'S024', N'MN013', '2022-05-07'),
(N'P017', '2022-01-12', '2023-12-12', N'S014', N'MN009', NULL),
(N'P018', '2022-06-07', '2023-01-01', N'S015', N'MN017', NULL),
(N'P019', '2020-03-25', '2022-06-07', N'S012', N'MN017', NULL),
(N'P020', '2022-06-07', '2023-01-01', N'S012', N'MN018', NULL),
(N'P021', '2022-08-07', '2023-11-01', N'S018', N'MN003', NULL),
(N'P022', '2022-01-12', '2023-11-01', N'S007', N'MN004', NULL),
(N'P023', '2022-06-07', '2023-11-01', N'S017', N'MN007', NULL),
(N'P024', '2022-08-07', '2023-01-01', N'S020', N'MN004', NULL);

IF OBJECT_ID('tb_sach', 'U') IS NOT NULL
    DROP TABLE tb_sach;

CREATE TABLE tb_sach (
    MaSach NVARCHAR(15) NOT NULL PRIMARY KEY,
    TenSach NVARCHAR(45) NOT NULL,
    TrangThai NVARCHAR(45) NOT NULL,
    MaDauSach NVARCHAR(15) NOT NULL,

    CONSTRAINT FK_Sach_DauSach FOREIGN KEY (MaDauSach)
        REFERENCES tb_dausach (MaDauSach)
);

INSERT INTO tb_sach (MaSach, TenSach, TrangThai, MaDauSach)
VALUES
(N'S001', N'Toán 10', N'Còn', N'DS001'),
(N'S002', N'Văn 10', N'Đã mượn', N'DS002'),
(N'S003', N'Hóa 12', N'Còn', N'DS004'),
(N'S004', N'Toán rời rạc', N'Đã mượn', N'DS005'),
(N'S005', N'Toán rời rạc', N'Đã mượn', N'DS005'),
(N'S006', N'Lập trình Java', N'Còn', N'DS006'),
(N'S007', N'Văn 10', N'Đã mượn', N'DS002'),
(N'S008', N'Lập trình C++', N'Đã mượn', N'DS007'),
(N'S009', N'Lý 12', N'Đã mượn', N'DS003'),
(N'S010', N'Toán rời rạc', N'Đã mượn', N'DS005'),
(N'S011', N'Lập trình Java', N'Đã mượn', N'DS006'),
(N'S012', N'Lập trình Java', N'Đã mượn', N'DS006'),
(N'S013', N'Toán 10', N'Còn', N'DS001'),
(N'S014', N'Lập trình C#', N'Đã mượn', N'DS009'),
(N'S015', N'Doremon', N'Đã mượn', N'DS013'),
(N'S016', N'Xác xuất thống kê', N'Còn', N'DS011'),
(N'S017', N'Lập trình C#', N'Đã mượn', N'DS009'),
(N'S018', N'Lập trình C#', N'Đã mượn', N'DS009'),
(N'S019', N'Trí tuệ nhân tạo', N'Còn', N'DS010'),
(N'S020', N'Giải tích 1', N'Đã mượn', N'DS012'),
(N'S021', N'Lập trình C#', N'Còn', N'DS009'),
(N'S022', N'Doremon', N'Còn', N'DS013'),
(N'S023', N'Lập trình Python', N'Đã mượn', N'DS008'),
(N'S024', N'Xác xuất thống kê', N'Còn', N'DS011'),
(N'S025', N'Xác xuất thống kê', N'Còn', N'DS011'),
(N'S026', N'Trí tuệ nhân tạo', N'Còn', N'DS010');
