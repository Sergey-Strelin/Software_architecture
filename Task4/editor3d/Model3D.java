package editor3d;

import java.util.ArrayList;
import java.util.Collection;

public class Model3D implements Entity{

    private static int counter = 10000;
    private int id;
    private Collection<Texture> textures;

    
    public Collection<Texture> getTextures() {
        if (textures == null){
            textures = new ArrayList<>();
        }
        return textures;
    }

    {
        id = ++counter;
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("3DModel #%s", id);
    }
}
