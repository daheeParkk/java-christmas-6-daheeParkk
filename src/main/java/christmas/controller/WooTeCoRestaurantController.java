package christmas.controller;

import christmas.service.ReservationService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class WooTeCoRestaurantController {
    
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final ReservationService reservationService = new ReservationService();
    
    public void operate() {
        entertainCustomer();
        confirmOrder();
        checkBenefits();
    }
    
    private void checkBenefits() {
        checkGiveawayMenu();
        checkDiscount();
        checkTotalDiscountAmount();
        checkAmountOfPayment();
        checkBadge();
    }
    
    private void checkGiveawayMenu() {
        outputView.outputGiveawayMenuHeader();
        outputView.outputGiveawayMenu(reservationService.checkGiveawayMenu());
    }
    
    private void checkDiscount() {
        outputView.outputBenefitsHeader();
        outputView.outputBenefits(reservationService.checkDiscount());
    }
    
    private void checkTotalDiscountAmount() {
        outputView.outputTotalBenefitAmountHeader();
        outputView.outputTotalBenefitAmount(reservationService.checkTotalDiscountAmount());
    }
    
    private void checkAmountOfPayment() {
        outputView.outputAmountOfPaymentHeader();
        outputView.outputAmountOfPayment(reservationService.checkAmountOfPayment());
    }
    
    private void checkBadge() {
        outputView.outputBadgeHeader();
        outputView.outputBadge(reservationService.checkBadge());
    }
    
    private void confirmOrder() {
        outputView.outputBenefitPreview(reservationService.checkReserveDate());
        
        outputView.outputOrderMenuHeader();
        outputView.outputOrderMenu(reservationService.checkOrderInformation());
        
        outputView.outputTotalOrderAmountHeader();
        outputView.outputTotalOrderAmount(reservationService.checkTotalOrderAmount());
    }
    
    private void entertainCustomer() {
        outputView.outputGreetings();
    
        int day = reserveDate();
        orderMenu(day);
    }
    
    private void orderMenu(int day) {
        boolean correct = false;
    
        while (!correct) {
            try {
                String menu = inputView.inputOrderMenu();
                reservationService.reserve(day, menu);
                correct = true;
            } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException | NullPointerException e) {
                outputView.outputErrorMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }
    
    private int reserveDate() {
        int day = 0;
        boolean correct = false;
        
        while (!correct) {
            try {
                day = Integer.parseInt(inputView.inputDateOfVisit());
                correct = true;
            } catch (IllegalArgumentException e) {
                outputView.outputErrorMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
        return day;
    }
}
