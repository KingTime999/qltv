package Process;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Object.PhieuMuon;

public class Process_PhieuMuon {
	Connect_database cd = new Connect_database();
	public ArrayList<PhieuMuon> getListPhieuMuon() {
		Connection cn = cd.getCon();
		ArrayList<PhieuMuon> ls = new ArrayList<>();
		String sql = "SELECT * FROM tb_phieumuon;";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PhieuMuon st = new PhieuMuon();
				st.setMaPhieuMuon(rs.getString("MaPhieuMuon"));
				st.setNgayMuon(rs.getDate("NgayMuon"));
				st.setHanTra(rs.getDate("HanTra"));
				st.setMaSach(rs.getString("MaSach"));
				st.setMaNguoiMuon(rs.getString("MaNguoiMuon"));
				st.setNgayTra(rs.getDate("NgayTra"));
				ls.add(st);
			}
		} catch (Exception e) {
			
		}
		return ls;
	}
	public boolean insertPhieuMuon(String MaPhieuMuon, Date NgayMuon, Date HanTra, String MaSach, String MaNguoiMuon) {
		Connection cn = cd.getCon();
		String sql = "INSERT INTO tb_phieumuon (MaPhieuMuon, NgayMuon, HanTra, MaSach, MaNguoiMuon) VALUES (?, ?, ?, ?, ?);";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, MaPhieuMuon);
			ps.setDate(2, NgayMuon);
			ps.setDate(3, HanTra);
			ps.setString(4, MaSach);
			ps.setString(5, MaNguoiMuon);
			ps.executeUpdate();
			ps.close();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			javax.swing.JOptionPane.showMessageDialog(null, "Lỗi SQL: " + e.getMessage(), "Lỗi", 1);
			return false;
		}
	}
	
	public boolean updatePhieuMuon(String MaPhieuMuon, Date NgayMuon, Date HanTra, String MaSach, String MaNguoiMuon, Date NgayTra) {
		Connection cn = cd.getCon();
		String sql = "UPDATE tb_phieumuon SET NgayMuon = ?, HanTra = ?, MaSach = ?, MaNguoiMuon = ?, NgayTra = ? WHERE MaPhieuMuon = ?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setDate(1, NgayMuon);
			ps.setDate(2, HanTra);
			ps.setString(3, MaSach);
			ps.setString(4, MaNguoiMuon);
			ps.setDate(5, NgayTra); // Có thể là null
			ps.setString(6, MaPhieuMuon);
			int rows = ps.executeUpdate();
			ps.close();
			if (rows == 0) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy phiếu mượn để cập nhật!", "Thông báo", 1);
				return false;
			}
			JOptionPane.showMessageDialog(null, "Cập nhật thành công!" , "Thông báo", 1);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cập nhật thất bại!\n" + e.getMessage(), "Thông báo", 1);
			return false;
		}
	}
	

	
	public boolean delPhieuMuon(String MaPhieuMuon) {
		Connection cn = cd.getCon();
		String sql = "delete from tb_phieumuon where MaPhieuMuon = ?";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, MaPhieuMuon);
			ps.executeUpdate();
			ps.close();

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	public boolean updatePhieuMuonNgayTra(Date NgayTra, String MaPhieuMuon) {
		Connection cn = cd.getCon();
		String sql = "UPDATE `qltv`.`tb_phieumuon` SET NgayTra = ? where MaPhieuMuon = ?";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setDate(1, NgayTra);
			ps.setString(2, MaPhieuMuon);
			ps.executeUpdate();
			ps.close();
			JOptionPane.showMessageDialog(null, "Cập nhật thành công!" , "Thông báo", 1);
			return true;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cập nhật thất bại!" , "Thông báo", 1);
			return false;
		}
	}
	
	
	public boolean delPhieuMuonDaTra() {
		Connection cn = cd.getCon();
		String sql = "delete from tb_phieumuon where NgayTra is not NULL";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean delSach(String MaSach) {
		Connection cn = cd.getCon();
		String sql = "delete from tb_sach where MaSach = ?";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1, MaSach);
			ps.executeUpdate();
			ps.close();
			return true;
			
		}catch (Exception e) {
			return false;
		}
	}
	
	public ArrayList<String> getSach(){
		Connection cn = cd.getCon();
		ArrayList< String> arr = new ArrayList<>();
				
		String sql = "Select distinct MaSach from tb_Sach  where TrangThai  = 'Còn' order by MaSach ASC;";
	//	String sql = "Select distinct MaSach from tb_Sach order by MaSach ASC;";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				arr.add(rs.getString("MaSach"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	
	public ArrayList<String> getMaNguoiMuon(){
		Connection cn = cd.getCon();
		ArrayList< String> arr = new ArrayList<>();
				
		String sql = "Select distinct MaNguoiMuon from tb_NguoiMuon order by MaNguoiMuon";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				arr.add(rs.getString("MaNguoiMuon"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

	// Kiểm tra mã phiếu mượn đã tồn tại
	public boolean isMaPhieuMuonExists(String maPhieuMuon) {
		Connection cn = cd.getCon();
		String sql = "SELECT 1 FROM tb_phieumuon WHERE MaPhieuMuon = ?";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, maPhieuMuon);
			ResultSet rs = ps.executeQuery();
			boolean exists = rs.next();
			rs.close();
			ps.close();
			return exists;
		} catch (Exception e) {
			return false;
		}
	}

	// Kiểm tra mã sách đã tồn tại
	public boolean isMaSachExists(String maSach) {
		Process_Sach ps = new Process_Sach();
		ArrayList<String> ds = ps.getListSachMa();
		return ds.contains(maSach);
	}

	// Kiểm tra mã người mượn đã tồn tại
	public boolean isMaNguoiMuonExists(String maNguoiMuon) {
		Process_NguoiMuon pnm = new Process_NguoiMuon();
		ArrayList<String> ds = pnm.getListMaNguoiMuon();
		return ds.contains(maNguoiMuon);
	}
}
