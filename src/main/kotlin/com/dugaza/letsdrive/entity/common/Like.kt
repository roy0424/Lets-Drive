package com.dugaza.letsdrive.entity.common

import com.dugaza.letsdrive.entity.base.BaseEntity
import com.dugaza.letsdrive.entity.user.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Index
import jakarta.persistence.Table
import jakarta.persistence.ManyToOne
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import java.util.UUID

@Entity
@Table(
    name = "common_like",
    indexes = [
        Index(name = "idx_common_like_target_id", columnList = "target_id"),
        Index(name = "idx_common_like_user_id", columnList = "user_id"),
    ]
)
class Like(
    @Column(nullable = false)
    val targetId: UUID,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,
) : BaseEntity() {
}