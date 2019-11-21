
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
  public class Book
  {
      // The fields.
      // Added static to be able to call from outside class
      private static String author;
      private static String title;
      private static int pages;
      private static String refNumber;
      private static int borrowed;
      /**
       * Set the author and title fields when this object
       * is constructed.
       */
      public Book(String bookAuthor, String bookTitle, int bookPages)
      {
          author = bookAuthor;
          title = bookTitle;
          pages = bookPages;
          refNumber = "";
      }
      // Add the methods here...

      public static String printAuthor(String author)
      {
        
        return author;

      }

      public static String printTitle(String title)
      {
        
        return title;

      }

      public static int getPages(int pages)
      {
        
        return pages;
      }

      public static String setRefNumber(String ref)
      {

        int refLength = ref.length();

        if(refLength>=3)
        {
          refNumber = ref;

        }
        else
        {
          System.out.println("Reference number must be at least 3 characters long");
        }
        return refNumber;
        
      }

      public static String getRefNumber()
      {
        return refNumber;
      }

      public static void  borrow()
      {

        borrowed = borrowed + 1;
        //same thing as saying borrowed+=1
        //same thing as saying borrowed++;
        
      }

      public static int getBorrowed()
      {
        return borrowed;
      }

      public static void printDetails()
      {

        System.out.println("Author: " + author);
        System.out.println("Title: " + title);
        System.out.println("Pages: " + Book.getPages(pages));


        int refLength = refNumber.length();
        if(refLength>0)
        {
          System.out.println("Reference Number: " + Book.setRefNumber(refNumber));
        }
        else
        {
          System.out.println("ZZZ");
        }
        
        System.out.println("RefTest: " + Book.getRefNumber());

        System.out.println("Number of times book has been borrowed: " + Book.getBorrowed());

      }

      public static void main(String[] args)
      {

        //within parentheses here : only write the field names of those that are in the header of the constructor 
        Book book = new Book("J.K Rowling","Harry Potter",670);

        borrowed = 200;


        //run this if you want to test it immediately without all the questions (with the scanner)
        for(int i=0;i<borrowed;i++)
        {
            borrow();
        }

        book.printDetails();

      }
  }



/*
Exercise 2.84

Add two methods, printAuthor and printTitle, to the outline Book class.
These should print the author and title fields, respectively, to the terminal window.

Exercise 2.85

Add a field, pages, to the Book class to store the number of pages.
This should be of type int, and its initial value should be passed to the single constructor,
along with the author and title strings. Include an appropriate getPages accessor method for this field.

Exercise 2.86

Add a method, printDetails, to the Book class.
This should print details of the author, title, and pages to the terminal window.
It is your choice how the details are formatted.
For instance, all three items could be printed on a single line, or each could be printed on a separate line.
You might also choose to include some explanatory text to help a user work out which is the author and which is the title, for example:

Title: Robinson Crusoe, Author: Daniel Defoe, Pages: 232

Exercise 2.87

Add a further field, refNumber, to the Book class.
This field can store a reference number for a library, for example.
It should be of type String and initialized to the zero length string ("") in the constructor,
as its initial value is not passed in a parameter to the constructor.
Instead, define a mutator for it with the following header:

public void setRefNumber(String ref)
The body of this method should assign the value of the parameter to the refNumber field.
Add a corresponding getRefNumber accessor to help you check that the mutator works correctly.

Exercise 2.88

Modify your printDetails method to include printing the reference number.
However, the method should print the reference number only if it has been set —
that is, the refNumber string has a non-zero length. If it has not been set, then print the string "ZZZ" instead.
Hint: Use a conditional statement whose test calls the length method on the refNumber string.

Exercise 2.89

Modify your setRefNumber mutator so that it sets the refNumber field only if the parameter is a string of at least three characters.
If it is less than three, then print an error message and leave the field unchanged.


Exercise 2.90

Add a further integer field, borrowed, to the Book class.
This keeps a count of the number of times a book has been borrowed.
Add a mutator, borrow, to the class. This should update the field by 1 each time it is called.
Include an accessor, getBorrowed, that returns the value of this new field as its result.
Modify printDetails so that it includes the value of this field with an explanatory piece of text.

*/
