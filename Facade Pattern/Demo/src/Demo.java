public class Demo {
    public static void main(String[] args) {
        ShopFacade shopFacade = new ShopFacade();
        shopFacade.buyProductByMoMoWithGrabShipping("Nick");
        System.out.println();
        shopFacade.buyProductByPayPalWithNinjaVanShipping("Nick");
    }
}
