package job;

public class Item {
    private int _id = 0;
    private String _reference;
    private String _name;
    private float _price;
    private int _amount;


    public Item(int id, String reference, String name, float price, int amount) {
        setId(id);
        setReference(reference);
        setName(name);
        setPrice(price);
        setAmount(amount);
    }

    public Item(String reference, String name, float price, int amount) {
        setReference(reference);
        setName(name);
        setPrice(price);
        setAmount(amount);
    }

    @Override
    public String toString() {
        return "Item{" +
                "_id=" + id() +
                ", _reference='" + reference() + '\'' +
                ", _name='" + name() + '\'' +
                ", _price=" + price() +
                ", _amount=" + amount() +
                '}';
    }


    public void setId(int id) {

        this._id = id;
    }

    public void setReference(String reference) {

        this._reference = reference;
    }

    public void setName(String name) {

        this._name = name;
    }

    public void setPrice(float price) {

        this._price = price;
    }

    public void setAmount(int amount) {

        this._amount = amount;
    }

    public int id() {

        return _id;
    }

    public String reference() {

        return _reference;
    }

    public String name() {

        return _name;
    }

    public float price() {

        return _price;
    }

    public int amount() {

        return _amount;
    }

}
