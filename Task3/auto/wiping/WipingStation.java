package auto.wiping;

import java.util.List;

public class WipingStation implements Wiping {
    public void processWiping (List<WipingType> wipingTypes){
        for (WipingType wipingType: wipingTypes)
            switch (wipingType) {
                case WipMirrors -> System.out.println("Протёрли зеркала!");
                case WipWindshield -> System.out.println("Помыли лобовое стекло!");
                case WipHeadlights -> System.out.println("Протёрли фары!");
        }

    }

    @Override
    public void washing(List<WipingType> wipingTypes) {
        processWiping(wipingTypes);
    }
}
