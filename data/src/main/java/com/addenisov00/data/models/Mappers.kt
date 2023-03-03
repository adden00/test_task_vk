package com.addenisov00.data.models

import com.addenisov00.domain.models.GiffItem


fun Data.toDomain(): GiffItem = GiffItem(
    id = this.id,
    url = this.images.preview_gif.url,
    rating = this.rating,
    slug = this.slug,
    title = this.title,
    username = this.username
)


