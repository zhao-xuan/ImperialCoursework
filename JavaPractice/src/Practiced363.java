import java.util.StringTokenizer;

class BirthDate {
  private int dayOfBirth;
  private int monthOfBirth;
  private int yearOfBirth;

  public BirthDate(int dayOfBirth, int monthOfBirth, int yearOfBirth) {
    this.dayOfBirth = dayOfBirth;
    this.monthOfBirth = monthOfBirth;
    this.yearOfBirth = yearOfBirth;
  }

  public boolean isDateOfBirthValid() {

    if (yearOfBirth < 0) {
      return false;
    }

    if (monthOfBirth < 1 || yearOfBirth > 12) {
      return false;
    }

    if (dayOfBirth < 1) {
      return false;
    }

    switch (monthOfBirth) {
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
        if (dayOfBirth > 31) {
          return false;
        }
        break;
      case 4:
      case 6:
      case 9:
      case 11:
        if (dayOfBirth > 30) {
          return false;
        }
        break;
      default:
        assert monthOfBirth == 2;
        if (dayOfBirth > (isLeapYear() ? 29 : 28)) {
          return false;
        }
    }

    return true;

  }

  private boolean isLeapYear() {
    // Deliberately simplified version of
    // leap year calculation
    return (yearOfBirth % 4 == 0);
  }

  public int getDayOfBirth() {
    return dayOfBirth;
  }

  public void setDayOfBirth(int dayOfBirth) {
    this.dayOfBirth = dayOfBirth;
  }

  public int getMonthOfBirth() {
    return monthOfBirth;
  }

  public void setMonthOfBirth(int monthOfBirth) {
    this.monthOfBirth = monthOfBirth;
  }

  public int getYearOfBirth() {
    return yearOfBirth;
  }

  public void setYearOfBirth(int yearOfBirth) {
    this.yearOfBirth = yearOfBirth;
  }
}

class House {
  private int houseNumber;
  private String address1;
  private String address2;
  private String postCode;

  public House(int houseNumber, String address1, String address2, String postCode) {
    this.houseNumber = houseNumber;
    this.address1 = address1;
    this.address2 = address2;
    this.postCode = postCode;
  }

  public int getHouseNumber() {
    return houseNumber;
  }

  public void setHouseNumber(int houseNumber) {
    this.houseNumber = houseNumber;
  }

  public String getAddress1() {
    return address1;
  }

  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  public String getAddress2() {
    return address2;
  }

  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }
}

class Person {

  private String forenames;
  private String surname;
  private BirthDate birthdate;
  private House house;

  private String nationalInsuranceNumber;

  public Person(String forename, String surname, BirthDate birthdate, House house, String nationalInsuranceNumber) {
    this.forenames = forename;
    this.surname = surname;
    this.birthdate = birthdate;
    this.house = house;
    this.nationalInsuranceNumber = nationalInsuranceNumber;
  }

  public boolean sameAddress(Person other) {
    return this.house.getHouseNumber() == other.getHouse().getHouseNumber()
        && this.house.getAddress1().equals(other.getHouse().getAddress1())
        && this.house.getAddress2().equals(other.getHouse().getAddress2())
        && this.house.getPostCode().equals(other.getHouse().getPostCode());
  }

  public String getInitials() {
    String result = "";
    StringTokenizer strTok = new StringTokenizer(forenames);
    while (strTok.hasMoreTokens()) {
      result += strTok.nextToken().charAt(0);
    }
    return result + surname.charAt(0);
  }

  public String toString() {
    return "Name: " + forenames + " " + surname + "\n"
        + "DOB: " + birthdate.getDayOfBirth() + "/" + birthdate.getMonthOfBirth() + "/" + birthdate.getYearOfBirth() + "\n"
        + "Address: " + house.getHouseNumber() + " " + house.getAddress1() + ", " + house.getAddress2() + ", " + house.getPostCode() + "\n"
        + "NI: " + nationalInsuranceNumber;

  }

  public String getForenames() {
    return forenames;
  }

  public void setForenames(String forenames) {
    this.forenames = forenames;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public BirthDate getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(BirthDate birthdate) {
    this.birthdate = birthdate;
  }

  public House getHouse() {
    return house;
  }

  public void setHouse(House house) {
    this.house = house;
  }

  public String getNationalInsuranceNumber() {
    return nationalInsuranceNumber;
  }

  public void setNationalInsuranceNumber(String nationalInsuranceNumber) {
    this.nationalInsuranceNumber = nationalInsuranceNumber;
  }

}