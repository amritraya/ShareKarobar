package com.example.app.marketDataApi;

public class SecurityData {
    private String securityName;
    private String lastTradedPrice;

    public SecurityData() {
    }

    public SecurityData(String securityName, String lastTradedPrice) {
        this.securityName = securityName;
        this.lastTradedPrice = lastTradedPrice;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public String getLastTradedPrice() {
        return lastTradedPrice;
    }

    public void setLastTradedPrice(String lastTradedPrice) {
        this.lastTradedPrice = lastTradedPrice;
    }
}
