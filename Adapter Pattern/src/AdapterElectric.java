public class AdapterElectric implements LedInterFace{
    VietNamPower adaptee;

    public AdapterElectric(VietNamPower adaptee) {
        this.adaptee = adaptee;
    }


    @Override
    public int connect() {
        int electric = this.downElectric(this.adaptee.getElectric());
        // Hiệu điện thế lớn hơn 3v bóng đèn sẽ cháy.
        if (electric > 3)
            return -1;
        //Hiệu điện thế bằng 3v bóng đèn phát sáng.
        if (electric == 3)
            return 1;
        // Đén không phát sáng.
        return 0;
    }

    private int downElectric(int electric) {
        return electric - 217;
    }
}
