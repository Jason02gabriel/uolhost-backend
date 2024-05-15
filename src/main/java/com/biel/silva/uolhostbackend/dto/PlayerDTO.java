package com.biel.silva.uolhostbackend.dto;

import com.biel.silva.uolhostbackend.model.GroupType;

public record PlayerDTO(
        String name,
        String email,
        String phoneNumber,
        GroupType groupType
)
{
}
