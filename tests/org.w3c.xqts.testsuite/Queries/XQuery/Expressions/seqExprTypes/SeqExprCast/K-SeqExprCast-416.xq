(:*******************************************************:)
(: Test: K-SeqExprCast-416                               :)
(: Written by: Frans Englich                             :)
(: Date: 2006-10-05T18:29:38+02:00                       :)
(: Purpose: The xs:untypedAtomic constructor function must be passed exactly one argument, not two. :)
(:*******************************************************:)
xs:untypedAtomic(
      "an arbitrary string(untypedAtomic source)"
    ,
                                                     
      "an arbitrary string(untypedAtomic source)"
    )