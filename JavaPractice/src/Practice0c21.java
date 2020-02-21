import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

enum HouseType {
    DETACHED, SEMIDETACHED, TERRACED;
}

interface Property {
    public Property getProperty();
}

class House implements Property {
    private HouseType houseType;
    private int bedrooms;
    private int reception;
    private int bathrooms;
    private int area;

    public House(HouseType houseType) {
        this.houseType = houseType;
    }

    @Override
    public House getProperty() {
        return this;
    }

    public HouseType getHouseType() {
        return this.houseType;
    }
}

class Bungalow extends House implements Property {

    public Bungalow(HouseType houseType) {
        super(houseType);
    }

    @Override
    public Bungalow getProperty() {
        return this;
    }

}

class Flat implements Property {
    private int bedrooms;
    private int reception;
    private int bathrooms;
    private int area;

    @Override
    public Flat getProperty() {
        // TODO Auto-generated method stub
        return null;
    }

    public Flat() {
    }

}

class Maisonette extends Flat implements Property {

    @Override
    public Maisonette getProperty() {
        return this;
    }
}

class PropertyCollection {
    private Set<Property> propertyList;

    public PropertyCollection() {
        this.propertyList = new HashSet<>();
    }
    // Add a property to the collection
    public void addProperty(Property p) {
        this.propertyList.add(p);
    }

    // Return the set of all houses in the collection
    public Set<House> getHouses() {
        return propertyList.stream().filter(i -> i instanceof House).map(i -> (House) i).collect(Collectors.toSet());
    }

    // Return the set of all bungalows in the collection
    public Set<Bungalow> getBungalows() {
        return propertyList.stream().filter(i -> i instanceof Bungalow).map(i -> (Bungalow) i).collect(Collectors.toSet());
    }

    // Return the set of all flats in the collection
    public Set<Flat> getFlats() {
        return propertyList.stream().filter(i -> i instanceof Flat).map(i -> (Flat) i).collect(Collectors.toSet());
    }

    // Return the set of all maisonettes in the collection
    public Set<Maisonette> getMaisonettes() {
        return propertyList.stream().filter(i -> i instanceof Maisonette).map(i -> (Maisonette) i).collect(Collectors.toSet());
    }

    // Return the set of all terraced houses in the collection
    public Set<House> getTerracedHouses() {
        return propertyList.stream().filter(i -> i instanceof House && ((House) i).getHouseType() == HouseType.TERRACED)
                .map(i -> (House) i).collect(Collectors.toSet());
    }
}