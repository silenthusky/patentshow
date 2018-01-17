package com.patentshow.common.error;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by unclexiao on 2017/11/30.
 */
@ResponseStatus(reason = "Spittle has existed!")
public class DuplicateSpittleException extends RuntimeException {
}
