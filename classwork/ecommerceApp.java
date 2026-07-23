import java.util.Date;

class Order{
    protected String orderId;
    protected double totalAmount;
    protected String orderDate;
    //parent constructor
    public Order(String orderId,double totalAmount){
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.orderDate = new Date().toString();
        System.out.println("order created:"+orderId);
    }
    //parent method 
    public double calculateDiscount(){
        return totalAmount *0.05;
    }
    public void displayorder(){
        System.out.println("order ID:"+orderId);
        System.out.println("Amount:$"+totalAmount);
        System.out.println("Date:"+orderDate);

    }

}

class premiumOrder extends Order{
    private String membershipTier;
    private double cashback;

    public premiumOrder(String orderId,double totalAmount,String membershipTier){
        super(orderId,totalAmount);
        this.membershipTier = membershipTier;
        // set cashback based on membership tier
        double rate = 0.05; // default 5%
        if(membershipTier != null){
            String tier = membershipTier.toLowerCase();
            if(tier.equals("gold")) rate = 0.10;
            else if(tier.equals("silver")) rate = 0.07;
            else if(tier.equals("bronze")) rate = 0.06;
        }
        this.cashback = totalAmount * rate;
    }

    class giftcardOrder extends Order{
        private String giftcardCode;
        private double giftcardValue;

        public giftcardOrder(String orderId,double totalAmount,String giftcardCode,double giftcardValue){
            super(orderId,totalAmount);
            this.giftcardCode = giftcardCode;
            this.giftcardValue = giftcardValue;
        }
        @Override
        public double calculateDiscount(){
            double baseDiscount = super.calculateDiscount();
           double giftcardDiscount = giftcardValue * 0.10; // 10% for gift card orders
            double finalDiscount = baseDiscount + giftcardDiscount;
            System.out.println("Gift card order discount calculated: $" + finalDiscount);
            return finalDiscount;
        }
        @Override
        public void displayorder(){
            super.displayorder();
            System.out.println("Gift Card Code:"+giftcardCode);
            System.out.println("Gift Card Value:$"+giftcardValue);
        }
    }

    @Override
    public double calculateDiscount(){
        double baseDiscount = super.calculateDiscount();
        double premiumDiscount = totalAmount * 0.10; // 10% for premium orders
        double finalDiscount = baseDiscount + premiumDiscount;
        System.out.println("Premium order discount calculated: $" + finalDiscount);
        return finalDiscount;
    }
    @Override
    public void displayorder(){
        super.displayorder();
        System.out.println("Membership Tier:"+membershipTier);
        System.out.println("Cashback:$"+cashback);
    }
}
public class ecommerceApp {
    public static void main(String[] args) {
        premiumOrder order = new premiumOrder("ORD123", 200.0, "Gold");
        order.displayorder();
        order.calculateDiscount();
    }
}


