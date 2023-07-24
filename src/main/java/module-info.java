module com.javafx.mylist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.javafx.mylist to javafx.fxml;
    exports com.javafx.mylist;
}