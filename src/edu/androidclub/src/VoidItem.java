import edu.androidclub.domain.Item;


// пустой предмет
public class VoidItem extends Item {
    public VoidItem() {
        super("Пустота", 0); // Вызов конструктора класса-родителя (класса Item)
    }
}