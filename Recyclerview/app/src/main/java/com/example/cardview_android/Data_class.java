package com.example.cardview_android;

public class Data_class {
    public class FlowerData {
        private String flowerName;
        private String flowerDescription;
        private int flowerImage;

        public FlowerData(String flowerName, String flowerDescription, int flowerImage) {
            this.flowerName = flowerName;
            this.flowerDescription = flowerDescription;
            this.flowerImage = flowerImage;
        }

        public String getFlowerName() {
            return flowerName;
        }

        public String getFlowerDescription() {
            return flowerDescription;
        }

        public int getFlowerImage() {
            return flowerImage;
        }
    }
}
