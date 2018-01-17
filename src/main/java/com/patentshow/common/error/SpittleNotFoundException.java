package com.patentshow.common.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by unclexiao on 2017/11/30.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,
        reason = "Spittle not found!"
)
public class SpittleNotFoundException extends RuntimeException {
}
