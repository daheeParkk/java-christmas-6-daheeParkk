package christmas.view;

import static christmas.message.OutputMessage.*;

import java.util.Map;

public class OutputView {
    
    public void outputGreetings() {
        System.out.println(GREETINGS.getMessage());
    }
    
    public void outputBenefitPreview(int day) {
        System.out.println(BENEFITS_PREVIEW.getMessageByDay(day));
    }
    
    public void outputOrderMenuHeader() {
        outputBlankLine();
        System.out.println(ORDER_MENU_HEADER.getMessage());
    }
    
    public void outputOrderMenu(Map<String, Integer> orderMenu) {
        for (String orderOneMenu : orderMenu.keySet()) {
            System.out.println(ORDER_MENU.getMessageWithCount(orderOneMenu, orderMenu.get(orderOneMenu)));
        }
    }
    
    public void outputTotalOrderAmountHeader() {
        outputBlankLine();
        System.out.println(TOTAL_ORDER_AMOUNT_HEADER.getMessage());
    }
    
    public void outputTotalOrderAmount(int orderAmount) {
        System.out.println(TOTAL_ORDER_AMOUNT.getMessage(orderAmount));
    }
    
    public void outputGiveawayMenuHeader() {
        outputBlankLine();
        System.out.println(GIVEAWAY_MENU_HEADER.getMessage());
    }
    
    public void outputGiveawayMenu(Map<String, Integer> giveawayMenu) {
        if (checkExist(giveawayMenu)) {
            return;
        }
        for (String giveawayOneMenu : giveawayMenu.keySet()) {
            System.out.println(GIVEAWAY_MENU.getMessageWithCount(giveawayOneMenu, giveawayMenu.get(giveawayOneMenu)));
        }
    }
    
    private boolean checkExist(Map<String, Integer> details) {
        if(details.containsKey(NOT_EXIST.getMessage())) {
            System.out.println(NOT_EXIST.getMessage());
            return true;
        }
        return false;
    }
    
    public void outputBenefitsHeader() {
        outputBlankLine();
        System.out.println(BENEFITS_HEADER.getMessage());
    }
    
    public void outputBenefits(Map<String, Integer> benefits) {
        if (checkExist(benefits)) {
            return;
        }
        for (String benefit : benefits.keySet()) {
            System.out.println(BENEFITS.getMessageWithAmount(benefit, benefits.get(benefit)));
        }
    }
    
    public void outputTotalBenefitAmountHeader() {
        outputBlankLine();
        System.out.println(TOTAL_BENEFIT_AMOUNT_HEADER.getMessage());
    }
    
    public void outputTotalBenefitAmount(int totalBenefitAmount) {
        System.out.println(TOTAL_BENEFIT_AMOUNT.getMessage(totalBenefitAmount));
    }
    
    public void outputAmountOfPaymentHeader() {
        outputBlankLine();
        System.out.println(AMOUNT_OF_PAYMENT_HEADER.getMessage());
    }
    
    public void outputAmountOfPayment(int amountOfPayment) {
        System.out.println(AMOUNT_OF_PAYMENT.getMessage(amountOfPayment));
    }
    
    public void outputBadgeHeader() {
        outputBlankLine();
        System.out.println(BADGE_HEADER.getMessage());
    }
    
    public void outputBadge(String name) {
        System.out.println(name);
    }
    
    private void outputBlankLine() {
        System.out.println();
    }
}
