class Node {
    int data;
    Node left;
    Node right;
    Node parent;
    int color; // 0=black, 1=red

}

public class RBtree_deletion{
    Node TNULL;
    Node root;

    public void delete_cases(Node del){
        Node colorswap = del;
        while(del.data==-1){
        if(del==del.parent.left){
            Node sibling=del.parent.right;
            Node childofsibling1 = sibling.left;
            Node childofsibling2 = sibling.right;
            // case 2
            if(sibling.color==1 && childofsibling1.color==0 && childofsibling2.color==0 ){
                System.out.println("CASE 2");
                colorswap.color = del.parent.color;
                del.parent.color = sibling.color;
                sibling.color = colorswap.color;
                rotateleft(del.parent);
            }
            //case 4
            else if(sibling.color==0 && childofsibling1.color==0 && childofsibling2.color==0 && del.parent.color==1){
                System.out.println("CASE 4");
                colorswap.color = del.parent.color;
                del.parent.color = sibling.color;
                sibling.color = colorswap.color;
                del.parent.left = TNULL;
                del.parent = TNULL;
                break;
            }
            // case 3
            else if(sibling.color==0 && del.parent.color==0 && childofsibling1.color==0 && childofsibling2.color==0){
                System.out.print("CASE 3");
                sibling.color = 1;
                del.parent.right = TNULL;
                del.parent = TNULL;
                del = del.parent;
                
            }
            //case 1
            else if(this.root == del){
                del.color=0; 
                break;
            }
        }
        else{
            Node sibling=del.parent.right;
            Node childofsibling1 = sibling.left;
            Node childofsibling2 = sibling.right;
            // case 2
            if(sibling.color==1 && childofsibling1.color==0 && childofsibling2.color==0 ){
                System.out.println("CASE 2");
                colorswap.color = del.parent.color;
                del.parent.color = sibling.color;
                sibling.color = colorswap.color;
                rotateright(del.parent);
            }
            //case 4
            else if(sibling.color==0 && childofsibling1.color==0 && childofsibling2.color==0 && del.parent.color==1){
                System.out.println("CASE 4");
                colorswap.color = del.parent.color;
                del.parent.color = sibling.color;
                sibling.color = colorswap.color;
                del.parent.right = TNULL;
                del.parent = TNULL;
                break;
            }
            // case 3
            else if(sibling.color==0 && del.parent.color==0 && childofsibling1.color==0 && childofsibling2.color==0){
                System.out.print("CASE 3");
                sibling.color = 1;
                del.parent.right = TNULL;
                del.parent = TNULL;
                del = del.parent;
            }
            //case 1
            else if(this.root == del){
                del.color=0; 
                break;
            }
        }
    }
    }

    public void inordersuc(int key){
        int found = 0;
        Node temp;
        Node delnode;
        temp=this.root;
        while(found!=1){
            if(temp.data==key){
                delnode=temp;
                if(temp.right==TNULL){
                    temp.data = -1;
                }
                else{
                temp=temp.right;
                while(temp.left!=TNULL){
                    temp=temp.left;
                }
            }
                found=1;
                delnode.data = temp.data;
            }
            else if(key<temp.data){
                temp=temp.left;
            }
            else{
                temp=temp.right;
            }

        }
        temp.data = -1;
        // if(temp.color == 1 && temp.left==TNULL && temp.right == TNULL){
        //     temp.parent.left
        // }
        delete_cases(temp);
    }

    public RBtree_deletion(){
        TNULL = new Node();
        TNULL.color=0;
        TNULL.left=null;
        TNULL.right=null;
        TNULL.parent=null;
        root = TNULL;
    }

    public void rotateleft(Node x){
        Node y = x.right; //16
        x.right = y.left; //null
        if (y.left != TNULL) {
        y.left.parent = x;
        }
        y.parent = x.parent; //18-16
        if (x.parent == null) {
        this.root = y;
        } else if (x == x.parent.left) {
        x.parent.left = y;
        } else {
        x.parent.right = y;
        }
        y.left = x;
        x.parent = y;    
        }

    public void rotateright(Node x){
        Node y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
        y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
        this.root = y;
        } else if (x == x.parent.right) {
        x.parent.right = y;
        } else {
        x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }
    

    public void fixInsert(Node node){
        System.out.print(node.data);
        Node uncle;
        while(node.parent.color==1){
        if(node.parent == node.parent.parent.right){
            uncle = node.parent.parent.left;
            if(uncle.color==1){
                uncle.color=0;
                node.parent.color=0;
                node.parent.parent.color=1;
                node=node.parent.parent;
            }
            else{
                if(node==node.parent.left){
                    node=node.parent;
                    rotateright(node);
                }
                    node.parent.color=0;
                    node.parent.parent.color=1;
                    rotateleft(node.parent.parent);
            }
        }
        else{
            uncle = node.parent.parent.right;
            if(uncle.color==1){
                uncle.color=0;
                node.parent.color=0;
                node.parent.parent.color=1;
                node=node.parent.parent;
            }
            else{
                if(node==node.parent.right){
                    node=node.parent;
                    rotateleft(node);
                }
                    node.parent.color=0;
                    node.parent.parent.color=1;
                    rotateright(node.parent.parent);
            }
            }
            if(node==root){
                break;
        }
        } 
        root.color=0;
    }

    public void insertion(int key){
        Node node = new Node();
        node.data = key;
        node.left = TNULL;
        node.right = TNULL;
        node.parent = TNULL;
        node.color = 1;

        Node y = null;
        Node x = this.root;

        while(x!=TNULL){
            y=x;
            if(node.data < x.data){
                x=x.left;
            }
            else{
                x=x.right;
            }
        }

        node.parent = y;
        if(y==null){
            root=node;
        }
        else if(node.data < y.data){
            y.left=node;
        }
        else{
            y.right=node;
        }

        if(node.parent == null){
            node.color=0;
            return;
        }
        if (node.parent.parent==null){
            return;
        }
        fixInsert(node); 
        
    }

    private void printHelper(Node root, String indent, boolean last) {
        if (root != TNULL) {
          System.out.print(indent);
          if (last) {
            System.out.print("R----");
            indent += "   ";
          } else {
            System.out.print("L----");
            indent += "|  ";
          }
    
          String sColor = root.color == 1 ? "RED" : "BLACK";
          System.out.println(root.data + "(" + sColor + ")");
          printHelper(root.left, indent, false);
          printHelper(root.right, indent, true);
        }
      }

    public void printTree() {
        printHelper(this.root, "", true);
      }

   

    public static void main(String[] args){
        RBtree_deletion bst = new RBtree_deletion();
        bst.insertion(50);
        bst.insertion(30);
        bst.insertion(15);
        bst.insertion(35);
        bst.insertion(65);
        bst.insertion(55);
        bst.insertion(70);
        bst.insertion(68);
        bst.insertion(80);
        bst.insertion(90);
        bst.inordersuc(50);
        // bst.inordersuc(30);
        bst.printTree();
    
    }
    
}


