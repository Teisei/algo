package hash;

import org.junit.Test;
import structure.domain.Person;

/**
 * Created by Teisei on 2015/3/23.
 * @author Teisei
 * @version 1.0
 */
public class DirectAddressTable {

    public class Node{
        public Person element;
        public int key;

        public Node(Person element, int key) {
            this.element = element;
            this.key = key;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element.toString() +
                    ", key=" + key +
                    '}';
        }
    }
    public Node[] table;
    public int max_size;

    public DirectAddressTable() {
    }

    public void setMax_size(int max_size) {
        this.max_size = max_size;
        table = new Node[max_size];
    }

    public void direct_address_insert(Node node) {
        System.out.println("insert node: " + node.toString());
        table[node.key] = node;
    }

    public Node direct_address_search(int key) {
        System.out.println("search by key: " + key);
        return table[key];
    }

    public Node direct_address_delete(int key) {
        System.out.println("delete by key: " + key);
        Node res = table[key];
        table[key] = null;
        return res;
    }

    public void printTable() {
        System.out.println("**** print the table ****");
        for (Node node : table) {
            if (node != null)
                System.out.println(node.toString());
        }
        System.out.println("\n\n\n");
    }


    @Test
    public void testOne() {
        DirectAddressTable hash = new DirectAddressTable();
        hash.setMax_size(100);

        Person a = new Person("teisei");
        Person b = new Person("shuntian");
        Person c = new Person("xutao");
        hash.direct_address_insert(new DirectAddressTable.Node(a, 1));
        hash.printTable();
        hash.direct_address_insert(new DirectAddressTable.Node(b, 50));
        hash.printTable();
        hash.direct_address_insert(new DirectAddressTable.Node(c, 90));
        hash.printTable();

        System.out.println(hash.direct_address_search(50).toString());
        hash.printTable();
        System.out.println(hash.direct_address_delete(50).toString());
        hash.printTable();
        System.out.println(hash.direct_address_search(90).toString());
        hash.printTable();
    }
}
