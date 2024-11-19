import java.util.HashMap;

public class Task {
    public static void main(String[] args) {
        ProductHashTable productHashTable = new ProductHashTable();

        productHashTable.addProduct(101, "Ноутбук", "Мощный ноутбук для работы", 1500.00, 10);
        productHashTable.addProduct(102, "Телефон", "Смартфон с большим экраном", 800.00, 20);
        productHashTable.addProduct(103, "Лампа", "Энергосберегающая лампа", 10.00, 50);
        productHashTable.addProduct(104, "Клавиатура", "Беспроводная клавиатура", 50.00, 15);

        productHashTable.findProduct(103);
        productHashTable.removeProduct(101);
        productHashTable.displayAllProducts();
    }
}

class ProductHashTable {
    private HashMap<Integer, Product> products;

    public ProductHashTable() {
        products = new HashMap<>();
    }

    public void addProduct(int article, String name, String description, double price, int quantity) {
        Product newProduct = new Product(article, name, description, price, quantity);
        products.put(article, newProduct);
        System.out.println("Товар с артикулом " + article + " добавлен");
    }

    public void findProduct(int article) {
        Product foundProduct = products.get(article);
        if (foundProduct != null) {
            System.out.println("Найден: " + foundProduct);
        } else {
            System.out.println("Товар с артикулом " + article + " не найден");
        }
    }

    public void removeProduct(int article) {
        if (products.containsKey(article)) {
            products.remove(article);
            System.out.println("Товар с артикулом " + article + " удалён");
        } else {
            System.out.println("Товар с артикулом " + article + " не найден");
        }
    }

    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Товаров нет");
        } else {
            products.forEach((article, product) -> {
                System.out.println(product);
            });
        }
    }
}

class Product {
    private int article;
    private String name;
    private String description;
    private double price;
    private int quantity;

    public Product(int article, String name, String description, double price, int quantity) {
        this.article = article;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String toString() {
        return "Артикул: " + article + ", Наименование: " + name + ", Описание: " + description + ", Цена: " + price + ", Количество: " + quantity;
    }
}