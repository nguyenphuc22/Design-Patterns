public class Led {
    public static void main(String[] args) {
        LedInterFace led = new AdapterElectric(new VietNamPower());

        switch (led.connect()) {
            // Nếu hiệu điện thế lớn 3v kết quả trả về -1
            case -1:
            {
                System.out.println("Crash");
                break;
            }
            // Nếu hiệu điện thế nhỏ hơn 3v kết quả trả về 0
            case 0:
            {
                System.out.println("Not Thing");
                break;
            }
            // Nếu hiệu điện thế bằng 3v kết quả trả về 1
            case 1:
            {
                System.out.println("Light");
                break;
            }
        }
    }
}
