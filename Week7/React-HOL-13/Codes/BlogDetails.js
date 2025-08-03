// src/BlogDetails.js
import React from 'react';

function BlogDetails({ posts }) {
    return (
        <div>
            <h2>Blog Details</h2>
            {posts.map((post) => (
                <div key={post.id}>
                    <h3>{post.title}</h3>
                    <h4>{post.author}</h4>
                    <p>{post.content}</p>
                </div>
            ))}
        </div>
    );
}

export default BlogDetails;