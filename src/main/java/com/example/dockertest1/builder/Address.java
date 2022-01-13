package com.example.dockertest1.builder;

public class Address {
    private String orderNo;
    private String address1;
    private String address2;
    private int postcode;
    private String state;


    public String getOrderNo() {
        return this.orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public int getPostcode() {
        return this.postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }


    private Address(AddressBuilder builder) {
        this.orderNo = builder.orderNo;
        this.address1 = builder.address1;
        this.address2 = builder.address2;
        this.postcode = builder.postcode;
        this.state = builder.state;
    }

    public static class AddressBuilder {
        private String orderNo;
        private String address1;
        private String address2;
        private int postcode;
        private String state;

        public AddressBuilder(String orderNo, String address1, String address2, int postcode, String state) {
            this.orderNo = orderNo;
            this.address1 = address1;
            this.address2 = address2;
            this.postcode = postcode;
            this.state = state;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
