package com.rakuten.PenguinSoldiers.util.form;

public class EnumPopulate {
  
  public static RateType[] populateRateType(){
    return new RateType[] {RateType.VERY_GOOD,RateType.GOOD, RateType.OKAY,RateType.BAD,RateType.VERY_BAD};
  }
  
  public static YesNoType[] populateYesNoType(){
    return new YesNoType[] {YesNoType.YES, YesNoType.NO, YesNoType.MAYBE};
  }
  
  public static PercentCompleteType[] populatePercentCompleteType(){
    return new PercentCompleteType[] {PercentCompleteType.ONE_HUNDRED,
                                      PercentCompleteType.MORE_SEVENTY,
                                      PercentCompleteType.MORE_FIFTY,
                                      PercentCompleteType.MORE_THIRTY,
                                      PercentCompleteType.ZERO};
  }
}
