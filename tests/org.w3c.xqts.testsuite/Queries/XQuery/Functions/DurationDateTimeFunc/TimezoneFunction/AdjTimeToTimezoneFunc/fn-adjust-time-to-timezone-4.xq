(:*******************************************************:)
(:Test: adjust-time-to-timezone-4                         :)
(:Written By: Carmelo Montanez                           :)
(:Date: August 10, 2005                                  :)
(:Test Description: Evaluates The "adjust-time-to-timezone" function   :)
(:as per example 4 (for this function) of the F&O  specs. :)
(:*******************************************************:)
let $tz := xs:dayTimeDuration("-PT10H")
return
fn:adjust-time-to-timezone(xs:time("10:00:00-07:00"), $tz)
