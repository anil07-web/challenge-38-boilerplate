import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.*;

public class Challenge38{

    public static void main(String[] args) 

    {
        BinaryTree bin = new BinaryTree();
        BufferedReader buff = null;
        try 
        {
            
            FileReader file = new FileReader("data//daffodils.txt");
            buff = new BufferedReader(file);
            String data = buff.readLine();

            while(data!=null)
            {
                String []str = data.split("[-, :;/.]");
                for (String string : str) 
                {
                    bin.insertAT(bin.root, string);    
                }
                data = buff.readLine();
            }
        } catch (Exception e) {
            System.out.println("Exceptional Handling");
        }    

        System.out.printf("%-20s \t\t %s\n", "Word", "Occurance");
        bin.showBST(bin.root);
        System.out.println();
        System.out.println("size : "+bin.size);
    }
}

class Word
{
    String words;
    int number;
    Word(String w)
    {
        this.words=w;
        number=1;
    }
}

class Node
{
    Word word;
    Node left ;
    Node right;

    Node(Word w)
    {
        this.word=w;
    }

    public boolean hasleft()
    {
        if(this.left==null)
        {
            return false;
        }
        else
        return true;
    }

    public boolean hasright()
    {
        if(this.right==null)
        {
            return false;
        }
        else
        return true;
    }

    public boolean isInternal()
    {
        if(this.left!=null || this.right!=null)
        {
            return true;
        }
        else return false;
    }

    public boolean isExternal()
    {
        if(this.left==null && this.right==null)
        {
            return true;
        }
        return false;
    }
}

class BinaryTree
{
    Node root = null;
    int size=0 ;

    public int size()
    {
        return this.size;
    }

    boolean isEmpty()
    {
        if(this.root!=null)
        {
            return false;
        }
        else return true;
    }
    public void insertAT(Node root , String word)
    {
        if(word.length()==0)
        {return;}
        if(this.root==null)
        {
            this.root = new Node(new Word(word));
            size = 1;
        }
        else if(root!=null)
        {
            if(word.compareToIgnoreCase(root.word.words)<0)
            {
                if(root.hasleft()==false)
                {
                    root.left=new Node(new Word(word));
                    size++;
                }
                else
                {
                    insertAT(root.left, word);
                }
            }
            else if(word.compareToIgnoreCase(root.word.words) > 0)
            {
                if(root.hasright() == false)
                {
                    root.right = new Node(new Word(word));
                    size++;
                }
                else
                {
                    insertAT(root.right, word);
                }
            }
            else
            {
                root.word.number++;
            }
        }
    }

    public void showBST(Node node)
    {
       if(node!=null)
       {
            showBST(node.left);
            System.out.printf("%-20s \t\t %d\n", node.word.words, node.word.number);
            showBST(node.right);
       }
    }    
}
