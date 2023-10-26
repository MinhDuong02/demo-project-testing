
package utils;

import dto.SanPham;
import java.io.Serializable;
import java.util.List;


public class Utils implements Serializable {

    public boolean checkExistInList(List<SanPham> list, String masp) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMasp().equals(masp)) {
                return true;
            }
        }
        return false;
    }

    public int getQuantity(List<SanPham> list, String masp) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMasp().equals(masp)) {
                return list.get(i).getSoLuong();
            }
        }
        return 1;
    }

    public void updateQuantity(List<SanPham> list, String masp, int soLuong) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMasp().equals(masp)) {
                list.get(i).setSoLuong(soLuong);
            }
        }
    }

    public float totalPrice(List<SanPham> list) {
        float total = 0;
        for (int i = 0; i < list.size(); i++) {
            total += list.get(i).getSoLuong() * list.get(i).getDonGia();
        }
        return total;
    }

    public boolean deleteProduct(List<SanPham> list, String masp) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMasp().equals(masp)) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    public String getAutoNumber(int n) {
        // chose a Character random from this String
        String number = "0123456789";
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            // generate a random number between  0 to 9 
            int index = (int) (number.length() * Math.random());
            // add Character one by one in end of sb
            sb.append(number.charAt(index));
        }
        return sb.toString();
    }

    public boolean updateProduct(List<SanPham> sanPhams, String masp, int soLuong) {
        for (int i = 0; i < sanPhams.size(); i++) {
            if (sanPhams.get(i).getMasp().equals(masp)) {
                sanPhams.get(i).setSoLuong(soLuong);
                return true;
            }
        }
        return false;
    }

    public float totalPriceProduct(List<SanPham> sanPhams) {
        float productPrice = 0;
        for (int i = 0; i < sanPhams.size(); i++) {
            productPrice += sanPhams.get(i).getSoLuong() * sanPhams.get(i).getDonGia();
        }
        return productPrice;
    }
}
