import java.util.Scanner;

 class IceCreamShop {
   static class ShopItems {
        int totalCount;

        class NonVegan {
            int iceCreamCount;
            int shakeCount;
            int totalCount;

            void increaseCount(int type, int count) {
                if (type == 1) {
                    iceCreamCount += count;
                } else if (type == 2) {
                    shakeCount += count;
                }

                // Shadowing to update the totalCount in the NonVegan class
                this.totalCount += count;

                // Shadowing to update the totalCount in the enclosing ShopItems class
                ShopItems.this.totalCount += count;
            }

             int getTotalCount() {
                return totalCount;
            }
        }

         class Vegan {
            int smoothieCount;
            int slushieCount;
            int totalCount;

             void increaseCount(int type, int count) {
                if (type == 3) {
                    smoothieCount += count;
                } else if (type == 4) {
                    slushieCount += count;
                }

                // Shadowing to update the totalCount in the Vegan class
                this.totalCount += count;

                // Shadowing to update the totalCount in the enclosing ShopItems class
                ShopItems.this.totalCount += count;
            }

             int getTotalCount() {
                return totalCount;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ShopItems shopItems = new ShopItems();
        ShopItems.NonVegan nonVegan = shopItems.new NonVegan();
        ShopItems.Vegan vegan = shopItems.new Vegan();

        while (true) {
            System.out.println("Welcome to the Ice Cream Shop!");
            System.out.println("1. Ice Cream (non-vegan)");
            System.out.println("2. Shake (non-vegan)");
            System.out.println("3. Smoothie (vegan)");
            System.out.println("4. Slushie (vegan)");
            System.out.println("5. Exit");
            System.out.print("Enter the type of treat you want (1-4) or 5 to Exit: ");

            int type = input.nextInt();
            if (type == 5) {
                break;
            }

            System.out.print("Enter the number of treats you want to order: ");
            int count = input.nextInt();

            System.out.print("Is this treat vegan? (true/false): ");
            boolean isVegan = input.nextBoolean();

            if (isVegan) {
                vegan.increaseCount(type, count);
            } else {
                nonVegan.increaseCount(type, count);
            }
        }

        int totalSales = nonVegan.getTotalCount() + vegan.getTotalCount();
        int nonVeganSales = nonVegan.getTotalCount();
        int veganSales = vegan.getTotalCount();

        System.out.println("Thank you for your order! Today we have sold " + totalSales + " orders of sweetness!");
        System.out.println(nonVeganSales + " items have been ice cream and shakes.");
        System.out.println(veganSales + " items have been smoothies and slushies.");

        input.close();
    }
}