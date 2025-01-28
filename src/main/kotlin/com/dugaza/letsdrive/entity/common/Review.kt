package com.dugaza.letsdrive.entity.common;

import com.dugaza.letsdrive.entity.base.BaseEntity
import com.dugaza.letsdrive.entity.common.evaluation.Evaluation
import com.dugaza.letsdrive.entity.file.FileMaster
import com.dugaza.letsdrive.entity.user.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Index
import jakarta.persistence.Table
import jakarta.persistence.OneToOne
import jakarta.persistence.ManyToOne
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import java.util.UUID

@Entity
@Table(
    name = "common_review",
    indexes = [
        Index(name = "idx_common_review_target_id", columnList = "target_id"),
        Index(name = "idx_common_review_user_id", columnList = "user_id"),
        Index(name = "idx_common_review_evaluation_id", columnList = "evaluation_id"),
        Index(name = "idx_common_review_file_id", columnList = "file_id"),
    ],
)
class Review(
    @Column(nullable = false)
    val targetId: UUID,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluation_id", nullable = false)
    val evaluation: Evaluation,

    @OneToOne
    @JoinColumn(name = "file_id", nullable = true)
    var file: FileMaster,

    @Column(nullable = false)
    var score: Double = 0.0,

    @Column(nullable = false)
    var content: String,

    @Column(nullable = false)
    var isDisplayed: Boolean = false
) : BaseEntity() {
}
