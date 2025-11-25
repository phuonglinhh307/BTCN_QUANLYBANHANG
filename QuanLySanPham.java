import java.util.*;

public class QuanLySanPham {
    private List<SanPham> dsSanPham;

    public QuanLySanPham() {
        dsSanPham = new ArrayList<>();
    }

    public boolean themSanPham(SanPham sp) {
        return dsSanPham.add(sp);
    }

    public boolean xoaSanPham(String maSP) {
        SanPham sp = timSanPham(maSP);
        if (sp != null) {
            dsSanPham.remove(sp);
            return true;
        }
        return false;
    }

    public SanPham timSanPham(String maSP) {
        for (SanPham sp : dsSanPham) {
            if (sp.getMaSP().equalsIgnoreCase(maSP)) {
                return sp;
            }
        }
        return null;
    }
    public boolean capNhatTonKho(String maSP, long soLuong) {
        SanPham sp = timSanPham(maSP);
        if (sp != null) {
            sp.setSoLuong((int) soLuong);
            return true;
        }
        return false;
    }

    public List<SanPham> getDsSanPham() {
        return dsSanPham;
    }
    public boolean capNhatSoLuong(String maSP, int soLuongMoi) {
        SanPham sp = timSanPham(maSP);
        if (sp != null) {
            sp.setSoLuong(soLuongMoi);
            return true;
        }
        return false;
    }
    public boolean capNhatThongTinSanPham(String ma, String tenMoi, String moTaMoi, double giaCoBanMoi) {
        SanPham sp = timSanPham(ma);
        if (sp != null) {
            sp.setTenSP(tenMoi);
            sp.setMoTa(moTaMoi);
            sp.setGiaCoBan(giaCoBanMoi);
            return true;
        }
        return false;
    }

    public void hienThiDanhSach() {
        for (SanPham sp : dsSanPham) {
            System.out.println(sp);
        }
    }
   public void sapXepTheoGiaBanGiamDan() {
        dsSanPham.sort((a, b) -> Double.compare(b.getGiaCoBan(), a.getGiaCoBan()));
   }
  
    public double tinhTongGiaTriKho() {
        double tong = 0;
        for (SanPham sp : dsSanPham) {
            tong += sp.tinhGiaBan() * sp.getSoLuong();
        }
        return tong;
    }
    
}
