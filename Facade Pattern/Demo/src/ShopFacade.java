public class ShopFacade {

    private LoginService loginService;
    private PayService payService;
    private ShipService shipService;
    private NotiService notiService;

    public ShopFacade() {
        this.loginService = new LoginService();
        this.payService = new PayService();
        this.shipService = new ShipService();
        this.notiService = new NotiService();
    }

    public void buyProductByMoMoWithGrabShipping(String name) {
        loginService.loginFB(name);
        payService.payByMoMo();
        shipService.grabShip();
        notiService.NotificationSMS();
    }

    public void buyProductByPayPalWithNinjaVanShipping(String name) {
        loginService.loginGithub(name);
        payService.payByPayPal();
        shipService.ninjaVanShip();
        notiService.NotificationGmail();
    }
}
