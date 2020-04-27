package domain.agents;

import domain.MarketPlace;
import domain.goods.PlasticGood;
import domain.goods.RawPlastic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecycleCenter extends Agent {
  private int leftoverBatches;

  public RecycleCenter(int thinkingTimeInMillis, MarketPlace marketPlace) {
    super(thinkingTimeInMillis, marketPlace);
    leftoverBatches = 0;
  }

  @Override
  protected void doAction() {
    Optional<PlasticGood> disposal = marketPlace.collectDisposedGood();
    List<PlasticGood> recycled = new ArrayList<>();
    if (disposal.isPresent()) {
      int numOfNewPlastic = 0;
      int numOfRecycledPlastic = leftoverBatches;
      for (RawPlastic r : disposal.get().getBasicMaterials()) {
        if (r.origin == RawPlastic.Origin.NEW) {
          numOfNewPlastic++;
        } else if (r.origin == RawPlastic.Origin.RECYCLED) {
          numOfRecycledPlastic++;
        }
      }
      leftoverBatches = numOfRecycledPlastic % 2 == 0 ? 0 : 1;
      int numOfBatches = numOfNewPlastic + (numOfRecycledPlastic / 2);
      for (int i = 0; i < numOfBatches; i++) {
        RawPlastic plastic = new RawPlastic(RawPlastic.Origin.RECYCLED);
        marketPlace.sellRawPlastic(plastic);
      }
    } else {
      think();
    }
  }
}
