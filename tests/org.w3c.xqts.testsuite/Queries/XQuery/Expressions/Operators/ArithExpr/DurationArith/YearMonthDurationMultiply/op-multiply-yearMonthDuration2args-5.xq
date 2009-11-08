(:*******************************************************:)
(:Test: op-multiply-yearMonthDuration2args-5              :)
(:Written By: Carmelo Montanez                            :)
(:Date: Tue Apr 12 16:29:08 GMT-05:00 2005                :)
(:Purpose: Evaluates The "op:multiply-yearMonthDuration" operator:)
(: with the arguments set as follows:                    :)
(:$arg1 = xs:yearMonthDuration(lower bound)             :)
(:$arg2 = xs:double(upper bound)                         :)
(:*******************************************************:)

xs:yearMonthDuration("P0Y0M") * xs:double("1.7976931348623157E308")