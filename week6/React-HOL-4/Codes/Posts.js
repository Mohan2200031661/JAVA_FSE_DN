import React from 'react';

class Posts extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            error: null,
        };
    }

    loadPosts() {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then((response) => response.json())
            .then((json) => this.setState({ posts: json }))
            .catch((error) => this.setState({ error: error }));
    }

    componentDidMount() {
        this.loadPosts();
    }

    componentDidCatch(error, info) {
        this.setState({ error: error });
        alert('An error occurred in the Posts component.');

    }

    render() {
        const { posts, error } = this.state;

        if (error) {
            return <div>Error: {error.message}</div>;
        }

        return (
            <div>
                {posts.map((post) => (
                    <div key={post.id}>
                        <h2>{post.title}</h2>
                        <p>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }
}

export default Posts;