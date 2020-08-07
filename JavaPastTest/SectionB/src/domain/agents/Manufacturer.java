package domain.agents;

import domain.MarketPlace;
import domain.goods.PlasticGood;
import domain.goods.RawPlastic;
import utils.Queue;
import utils.SafeQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Manufacturer extends Agent {

  private final int neededRawPlasticBatches;

  public Manufacturer(int neededRawPlasticBatches, int thinkingTimeInMillis,
      MarketPlace marketPlace) {
    super(thinkingTimeInMillis, marketPlace);
    if (neededRawPlasticBatches < 1) {
      throw new IllegalArgumentException();
    }
    this.neededRawPlasticBatches = neededRawPlasticBatches;
  }

  @Override
  protected void doAction() {
    List<RawPlastic> collectedBatches = new ArrayList<>();
    while(collectedBatches.size() < neededRawPlasticBatches) {
      Optional<RawPlastic> plastic = marketPlace.buyRawPlastic();
      if (plastic.isEmpty()) {
        think();
      } else {
        collectedBatches.add(plastic.get());
      }
    }
    PlasticGood good = new PlasticGood(collectedBatches);
    marketPlace.sellPlasticGood(good);
  }
}
