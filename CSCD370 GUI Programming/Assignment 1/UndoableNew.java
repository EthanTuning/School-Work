package etuninghw1;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javax.swing.undo.AbstractUndoableEdit;

public class UndoableNew extends AbstractUndoableEdit{
    
    private Canvas mLiveCanvas;
    private Canvas mDuplicate;
    
    public UndoableNew(Canvas canvas) {
        
        mLiveCanvas = canvas;
        mDuplicate = duplicateCanvas(canvas);
    }
    
    private Canvas duplicateCanvas(Canvas original) {
        
        WritableImage originalImage = original.snapshot(null, null);
        Canvas newCanvas = new Canvas(original.getWidth(), original.getHeight());
        GraphicsContext gc = newCanvas.getGraphicsContext2D();
        gc.drawImage(originalImage, 0, 0);
        
        return newCanvas;
    }
    
    private void copyCanvas(Canvas source, Canvas destination) {
        
        WritableImage sourceImage = source.snapshot(null, null);
        GraphicsContext gc = destination.getGraphicsContext2D();
        gc.drawImage(sourceImage, 0, 0);
    }
    
    @Override
    public void undo() {
        Canvas tempCanvas = duplicateCanvas(mLiveCanvas);
        copyCanvas(mDuplicate, mLiveCanvas);
        copyCanvas(tempCanvas, mDuplicate);
    }
    
    @Override
    public void redo() {
        Canvas tempCanvas = duplicateCanvas(mLiveCanvas);
        copyCanvas(mDuplicate, mLiveCanvas);
        copyCanvas(tempCanvas, mDuplicate);
    }
    
    @Override
    public boolean canRedo() {
        return true;
    }
    
    @Override
    public String getPresentationName() {
        return "New";
    }
}