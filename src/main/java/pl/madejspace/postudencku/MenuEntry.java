package pl.madejspace.postudencku;

public class MenuEntry {
    private long id;
    private String name;
    private double price;
    private String image_url;
    private MenuCategory category;

    public MenuEntry() {
        name = "";
        price = 0;
        image_url = "";
        category = new MenuCategory(0,"");
    }

    public MenuEntry(long id, String name, double price, String image_url, MenuCategory category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image_url = image_url;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageURL() {
        return image_url;
    }

    public void setImageURL(String image_url) {
        this.image_url = image_url;
    }

    public MenuCategory getCategory() {
        return category;
    }

    public void setCategory(MenuCategory category) {
        this.category = category;
    }
}
