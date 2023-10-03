import './DetailsContainer.css';

interface ContainerProps {
    imagePath: string;
    altText: string;
}

export default function DetailsContainer({ imagePath, altText }: ContainerProps) {
    return (
        <div className='image-container'>
            <img className="image" src={imagePath} alt={altText} />
        </div>
    )
}
