(:*******************************************************:) 
(: Test: fn-boolean-mixed-args-023.xq          :) 
(: Written By: Pulkita Tyagi                             :) 
(: Date: Mon May 23 04:50:42 2005                        :) 
(: Purpose: arg: double                                  :) 
(:*******************************************************:) 
 
<return> 
  { fn:boolean(xs:double('NaN')) } 
</return> 
