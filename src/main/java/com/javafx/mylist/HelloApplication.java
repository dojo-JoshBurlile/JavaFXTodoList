package com.javafx.mylist;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private ListView<String> tasksListView; // ListView to display the tasks.
    private TextField taskTextField; // TextField to input new tasks.

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Todo List App");

        // Initialize the ListView with some sample tasks.
        tasksListView = new ListView<>();
        tasksListView.setItems(FXCollections.observableArrayList("Task 1", "Task 2", "Task 3"));

        // Create a remove button and set an event handler for removing tasks.
        Button removeButton = new Button("Remove");
        removeButton.setOnAction(e -> removeTask());

        // Create an HBox to hold the tasks ListView and the remove button.
        HBox tasksBox = new HBox(10, tasksListView, removeButton);
        tasksBox.setPadding(new Insets(10));

        // Create a TextField for entering new tasks and a button to add them.
        taskTextField = new TextField();
        Button addButton = new Button("Add Task");
        addButton.setOnAction(e -> addTask());

        // Create an HBox to hold the taskTextField and the addButton.
        HBox addBox = new HBox(10, taskTextField, addButton);
        addBox.setPadding(new Insets(10));

        // Create a VBox to hold all the GUI components vertically.
        VBox root = new VBox(10);
        Label titleLabel = new Label("My Todo List");
        titleLabel.setStyle("-fx-font-size: 24pt; -fx-font-weight: bold;");
        root.getChildren().addAll(titleLabel, tasksBox, addBox);

        // Create a scene with the VBox as the root and set it in the stage.
        Scene scene = new Scene(new BorderPane(root), 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to add a new task to the ListView.
    private void addTask() {
        String newTask = taskTextField.getText().trim();
        if (!newTask.isEmpty()) {
            tasksListView.getItems().add(newTask);
            taskTextField.clear(); // Clear the TextField after adding the task.
        }
    }

    // Method to remove the selected task from the ListView.
    private void removeTask() {
        int selectedIndex = tasksListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            tasksListView.getItems().remove(selectedIndex);
        }
    }
}