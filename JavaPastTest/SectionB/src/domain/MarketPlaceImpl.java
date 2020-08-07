package domain;

import domain.goods.ExchangeableGood;
import domain.goods.PlasticGood;
import domain.goods.RawPlastic;
import utils.Queue;
import utils.SafeQueue;

import java.util.Optional;


public class MarketPlaceImpl implements MarketPlace {

  private final boolean DEBUG_MESSAGES = true;
  private Queue<RawPlastic> newPlastic = new SafeQueue<>();
  private Queue<RawPlastic> recycledPlastic = new SafeQueue<>();
  private Queue<PlasticGood> plasticGood = new SafeQueue<>();
  private Queue<PlasticGood> disposedGood = new SafeQueue<>();

  public void sellRawPlastic(RawPlastic plasticItem) {
    if (DEBUG_MESSAGES) {
      System.out
          .println("Thread: " + Thread.currentThread().getId() + " - Sell plastic: " + plasticItem);
    }
    if (plasticItem.origin == RawPlastic.Origin.NEW) {
      newPlastic.push(plasticItem);
    } else if(plasticItem.origin == RawPlastic.Origin.RECYCLED) {
      recycledPlastic.push(plasticItem);
    }
  }

  public Optional<RawPlastic> buyRawPlastic() {
    if (recycledPlastic.size() > 0) {
      return recycledPlastic.pop();
    } else if (newPlastic.size() > 0) {
      return newPlastic.pop();
    }
    return Optional.empty();
  }

  public void sellPlasticGood(PlasticGood good) {
    if (DEBUG_MESSAGES) {
      System.out.println("Thread: " + Thread.currentThread().getId() + " - Sell good: " + good);
    }
    plasticGood.push(good);
  }

  public Optional<PlasticGood> buyPlasticGood() {
    return plasticGood.pop();
  }

  public void disposePlasticGood(PlasticGood good) {
    if (DEBUG_MESSAGES) {
      System.out.println("Thread: " + Thread.currentThread().getId() + " - Dispose good: " + good);
    }
    disposedGood.push(good);
  }

  public Optional<PlasticGood> collectDisposedGood() {
    return disposedGood.pop();
  }
}
