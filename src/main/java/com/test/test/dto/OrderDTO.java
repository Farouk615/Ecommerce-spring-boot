package com.test.test.dto;

import com.test.test.entity.User;

public record OrderDTO(
        Long id,
        String oname,
        User user
) {
}
