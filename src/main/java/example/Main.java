package example;

import example.model.SealedInterface;
import example.model.TypeA;
import example.model.TypeB;

public class Main {

  public void apply(SealedInterface sealedInterface) {
    switch (sealedInterface) {
      case TypeA a -> a.apply("TEST");
      case TypeB b -> b.apply(1);
    }
  }
}
