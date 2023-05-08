async function addNewPost() {
    const postText = document.getElementById('post-text').value;
    if (postText.length === 0) return;

    const postImage = document.getElementById('post-image').files[0];
    let imageDataUrl = null;

    if (postImage) {
        imageDataUrl = await toBase64(postImage);
    }

    const post = document.createElement('div');
    post.classList.add('post');
    post.innerHTML = `
      <div class="post-container">
        <div class="post-text">${postText}</div>
        ${imageDataUrl ? `<img src="${imageDataUrl}" alt="업로드된 이미지">` : ''}
        <div class="like-container">
          <button class="like-button" onclick="toggleLike(this)">좋아요</button>
          <span class="like-counter">0</span>
        </div>
      </div>
  `;

    const timeline = document.getElementById('timeline');
    timeline.insertBefore(post, timeline.firstChild);

    document.getElementById('post-text').value = '';
    document.getElementById('post-image').value = '';
}

function toggleLike(button) { /* 이전 코드는 동일하게 유지 */ }

function toBase64(file) {
    return new Promise((resolve) => {
        const reader = new FileReader();
        reader.onload = (e) => resolve(e.target.result);
        reader.readAsDataURL(file);
    });
}