package etuninghw3;

import java.util.concurrent.ThreadLocalRandom;
import javafx.geometry.HPos;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

public class MyPanel extends Region {

    private final Clipboard mClipboard = Clipboard.getSystemClipboard();
    private ClipboardContent mClipboardContent = new ClipboardContent();
    private Label mText;
    private Rectangle mRect;
    private ContextMenu mContextMenu;
    private MyText mData;
    private static DataFormat key = new DataFormat("MyText");

    public MyPanel(String text, double red, double green, double blue) {

        buildContextMenu();
        mText = new Label(text);
        
        Color color = new Color(red, green, blue, 1);
        mRect = new Rectangle(getWidth(), getHeight(), color);
        mRect.widthProperty().bind(widthProperty());
        mRect.heightProperty().bind(heightProperty());
        mRect.setOnMouseClicked(this::showContextMenu);
        
        mText.setMinWidth(200);
        mText.setAlignment(Pos.CENTER);
        
        getChildren().addAll(mRect, mText);
        setPrefSize(400, 200);
        
        mData = new MyText(text, red*255, green*255, blue*255);

    }

    private void onCopy() {

        mClipboardContent.put(key, mData);
        mClipboardContent.putString(mData.toString());
        mClipboard.setContent(mClipboardContent);

    }
    
    private void onPaste() {

        if(mClipboard.hasContent(key)) {

            mData = (MyText) mClipboard.getContent(key);
            mText.setText(mData.TEXT);
            mRect.setFill(Color.rgb((int)mData.RED, (int)mData.GREEN, (int)mData.BLUE));

        }
        if(mClipboard.hasString()) {

            String str = mClipboard.getString().trim();
            
            if (!str.equals("")) {

                mText.setText(str);
                mData.TEXT = str;
                
            }
        }
        System.out.println(mData);
    }

    private void onColor() {

        int red = ThreadLocalRandom.current().nextInt(1, 255 + 1);
        int green = ThreadLocalRandom.current().nextInt(1, 255 + 1);
        int blue = ThreadLocalRandom.current().nextInt(1, 255 + 1);
        
        mRect.setFill(Color.rgb(red, green, blue));
        
        mData.RED = red;
        mData.GREEN = green;
        mData.BLUE = blue;

    }

    private void onText() {

        TextInputDialog dialog = new TextInputDialog();
        dialog.setContentText("Input the text to show");
        dialog.showAndWait();
        String str = dialog.getResult();
        
        if (str != null) {

            mText.setText(dialog.getResult());
            mData.TEXT = dialog.getResult();

        }

    }

    private void buildContextMenu() {

        MenuItem copy = new MenuItem("Copy");
        copy.setOnAction(actionEvent -> onCopy());
        
        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(actionEvent -> onPaste());
        
        MenuItem text = new MenuItem("Change Text");
        text.setOnAction(actionEvent -> onText());
        
        MenuItem color = new MenuItem("Change Color");
        color.setOnAction(actionEvent -> onColor());
        
        mContextMenu = new ContextMenu(text, color, copy, paste);

    }

    private void showContextMenu(MouseEvent mouseEvent) {

        if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            
            mContextMenu.show(this, mouseEvent.getScreenX(), mouseEvent.getScreenY());
            
        }

    }

    @Override
    public void layoutChildren() {

        double rectWidth = mRect.getWidth();
        double rectHeight = mRect.getHeight();
        
        double textWidth = mText.getWidth();
        double textHeight = mText.getHeight();
        
        double x = (rectWidth / 2) - (textWidth / 2);
        double y = (rectHeight / 2) - (textHeight / 2);
        
        mText.relocate(x, y);

        layoutInArea(mText, x, y, mText.getWidth(), mText.getHeight(), 0, HPos.CENTER, VPos.CENTER);
    }
}