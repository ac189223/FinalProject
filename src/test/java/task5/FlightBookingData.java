package task5;

class FlightBookingData {
    private String departureAirport = "WAW";
    private String arrivalAirport = "JFK";
    private String departureDate = "2019-10-10";
    private String arrivalDate = "2019-10-30";
    private int numberOfPassengers = 1;
    private String searchResultsURL = "https://www.phptravels.net/thflights/search/" +
            departureAirport + "/" + arrivalAirport + "/return/" +
            departureDate + "/" + arrivalDate + "/" + numberOfPassengers + "/0/0";
    private String title;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String birthday;
    private String idCardNumber;
    private String idCardExpirationDate;
    private String Nationality;
    private String cardType;
    private String cardNumber;
    private String cardExpirationMonth;
    private String cardExpirationYear;
    private String cvvNumber;

    String getDepartureAirport() {
        return departureAirport;
    }

    String getArrivalAirport() {
        return arrivalAirport;
    }

    String getDepartureDate() {
        return departureDate;
    }

    String getArrivalDate() {
        return arrivalDate;
    }

    int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    String getSearchResultsURL() {
        return searchResultsURL;
    }

    String getTitle() {
        return title;
    }

    String getName() {
        return name;
    }

    String getSurname() {
        return surname;
    }

    String getEmail() {
        return email;
    }

    String getPhone() {
        return phone;
    }

    String getBirthday() {
        return birthday;
    }

    String getIdCardNumber() {
        return idCardNumber;
    }

    String getIdCardExpirationDate() {
        return idCardExpirationDate;
    }

    String getNationality() {
        return Nationality;
    }

    String getCardType() {
        return cardType;
    }

    String getCardNumber() {
        return cardNumber;
    }

    String getCardExpirationMonth() {
        return cardExpirationMonth;
    }

    String getCardExpirationYear() {
        return cardExpirationYear;
    }

    String getCvvNumber() {
        return cvvNumber;
    }
}
